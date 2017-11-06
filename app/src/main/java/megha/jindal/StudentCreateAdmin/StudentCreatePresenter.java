package megha.jindal.StudentCreateAdmin;

import android.graphics.ComposePathEffect;

import com.google.firebase.database.FirebaseDatabase;

import org.reactivestreams.Subscriber;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import megha.jindal.FirebaseDatabase.DataInfo;
import megha.jindal.FirebaseDatabase.DataService;
import megha.jindal.FirebaseDatabase.DataSource;
import megha.jindal.firebase.Data;

/**
 * Created by Megha Chauhan on 02-Nov-17.
 */

public class StudentCreatePresenter implements StudentCreateContract.Presenter {
    StudentCreateContract.View view;

    CompositeDisposable disposable = new CompositeDisposable();
    DataService dataService= DataService.getInstance();

    StudentCreatePresenter(StudentCreateContract.View view) {
        this.view = view;
    }


    @Override
    public void onStudentCreate() {
        final DataInfo dataInfo=new DataInfo(view.getEmail(),view.getPassword(),view.getBranch(),view.getSname(),view.getCgpa(),view.getRoll());

        disposable.add(dataService.createStudent(dataInfo).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableCompletableObserver() {
                        @Override
                        public void onComplete() {
                            view.showProgressBar(false);
                            view.showToast("Account Created");


                        }

                        @Override
                        public void onError(Throwable e) {
                          e.getMessage();
                        }
                    }));
    }
}

