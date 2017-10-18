package megha.jindal.AdminLogin;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;
import megha.jindal.firebase.Data;
import megha.jindal.firebase.FireBaseAuthen;

/**
 * Created by Megha Chauhan on 17-Oct-17.
 */

public class LoginPresenter implements LoginContract.presenter {

    LoginContract.view view;
    FireBaseAuthen authen=new FireBaseAuthen();
    CompositeDisposable disposable=new CompositeDisposable();

    LoginPresenter(LoginContract.view view){
        this.view=view;
    }

    @Override
    public void onLogin() {

        final Data data;
         data=new Data(view.getEmail(),view.getPassword());

         view.showProgressBar(true);
         disposable.add(authen.login(data)
                 .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                 .subscribeWith(new DisposableCompletableObserver(){
                     @Override
                     public void onComplete() {
                         view.showProgressBar(true);
                         view.StudentCreateActivity();
                     }

                     @Override
                     public void onError(Throwable e) {
                         view.showProgressBar(true);
                         view.showToast(e.getMessage());

                     }
                 }));

    }
}
