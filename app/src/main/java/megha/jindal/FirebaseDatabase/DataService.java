package megha.jindal.FirebaseDatabase;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import megha.jindal.firebase.Data;


/**
 * Created by Megha Chauhan on 01-Nov-17.
 */

public class DataService implements DataSource {

    private String email,pass;

    private DataService() {
    }

    public static DataService getInstance() {
        return new DataService();
    }


    @Override
    public Completable createStudent(final DataInfo dataInfo) {
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(final CompletableEmitter e) throws Exception {
                DatabaseReference pref = FirebaseDatabase.getInstance().getReference();
                final DatabaseReference cref = pref.child(dataInfo.getRoll());

                cref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(final DataSnapshot dataSnapshot) {
                        if (!dataSnapshot.exists()) {
                            cref.setValue(dataInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isComplete()) {
                                        e.onComplete();
                                    } else {
                                        e.onError(task.getException());
                                    }
                                }
                            });
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        databaseError.getMessage();
                    }
                });
            }
        });

    }

 @Override
    public Completable studentLogin(final DataInfo dataInfo) {
        return Completable.create(new CompletableOnSubscribe() {

            @Override
            public void subscribe(final CompletableEmitter e) throws Exception {

                DatabaseReference pref = FirebaseDatabase.getInstance().getReference();
                final DatabaseReference cref = pref.child(dataInfo.getRoll());
                cref.orderByKey().equalTo(dataInfo.getEmail().toString()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot data:dataSnapshot.getChildren()) {
                                email = (String) data.child("email").getValue();
                                pass=(String)data.child("pass").getValue();

                            }
                            if(((dataInfo.getEmail()).equals(email)) && (dataInfo.getPassword().equals(pass))) {
                                e.onComplete();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        databaseError.getMessage();
                    }
                });
            }
        });
    }




}


