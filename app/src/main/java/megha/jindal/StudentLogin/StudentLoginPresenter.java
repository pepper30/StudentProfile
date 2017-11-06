package megha.jindal.StudentLogin;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import megha.jindal.FirebaseDatabase.DataInfo;
import megha.jindal.FirebaseDatabase.DataService;
import megha.jindal.StudentCreateAdmin.StudentCreatePresenter;

/**
 * Created by Megha Chauhan on 04-Nov-17.
 */

public class StudentLoginPresenter implements StudentLoginContract.Presenter {
    StudentLoginContract.View view;

    private DataService dataService = DataService.getInstance();
    private CompositeDisposable disposable = new CompositeDisposable();

   StudentLoginPresenter(StudentLoginContract.View view){
       this.view=view;
   }

    @Override
    public void loginClick() {
      final DataInfo studentDataInfo=new DataInfo(view.getEmail(),view.getPassword(),view.getRoll());
        disposable.add(dataService.studentLogin(studentDataInfo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<DataInfo>() {

                    @Override
                    public void onSuccess(DataInfo dataInfo) {
                        view.showProgressBar(true);
                        view.startProfileActivity(dataInfo);
                        view.showToast("Successfully logged in");
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showToast(e.getMessage());
                    }
                }));
             }
    }


