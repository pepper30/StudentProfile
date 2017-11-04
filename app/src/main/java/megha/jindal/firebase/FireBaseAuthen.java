package megha.jindal.firebase;


import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;

/**
 * Created by Megha Chauhan on 15-Oct-17.
 */

public class FireBaseAuthen implements AuthSource {
    FirebaseAuth auth;

    public FireBaseAuthen() {
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public Completable createacc(final Data data) {
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(final CompletableEmitter e) throws Exception {
                auth.createUserWithEmailAndPassword(data.getEmail(), data.getPassword())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                    e.onComplete();
                                else
                                    e.onError(task.getException());
                            }
                        });
            }
        });
    }

    @Override
    public Completable login(final Data data) {
        return Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(final CompletableEmitter e) throws Exception {
                auth.signInWithEmailAndPassword(data.getEmail(), data.getPassword())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                    e.onComplete();
                                else
                                    e.onError(task.getException());
                            }
                        });
            }
        });
    }
}


