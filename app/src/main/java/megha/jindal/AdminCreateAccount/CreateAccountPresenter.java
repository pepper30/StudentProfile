package megha.jindal.AdminCreateAccount;

import android.content.Intent;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;
import megha.jindal.AdminLogin.LoginActivity;
import megha.jindal.firebase.Data;
import megha.jindal.firebase.FireBaseAuthen;

/**
 * Created by Megha Chauhan on 16-Oct-17.
 */

public class CreateAccountPresenter implements CreateAccountContract.presenter {
    FireBaseAuthen authen=new FireBaseAuthen();
    CompositeDisposable disposable=new CompositeDisposable();
    CreateAccountContract.view view;

    CreateAccountPresenter(CreateAccountContract.view view) {
        this.view = view;
    }

    @Override
    public void OnCreateClick() {

        final Data data;
         data = new Data(view.getEmail(), view.getPassword());

        disposable.add(authen.createacc(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        view.ShowProgressbar(true);
                        view.StartLoginActivity();

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.ShowProgressbar(true);
                        view.ShowToast(e.getMessage());

                    }
                }));
    }
}


