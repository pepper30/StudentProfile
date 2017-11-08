package megha.jindal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;
import megha.jindal.AdminLogin.LoginActivity;
import megha.jindal.StudentLogin.StudentLoginActivity;
import megha.jindal.firebase.Data;
import megha.jindal.firebase.FireBaseAuthen;

public class MainActivity extends AppCompatActivity {

    ImageButton admin_log,stu_log,achieve,abt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        admin_log=findViewById(R.id.adlog);
        stu_log=findViewById(R.id.stulog);
        achieve=findViewById(R.id.achievements);
        abt=findViewById(R.id.about);

        admin_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        achieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,Achievements.class);
                startActivity(intent);
            }
        });

        abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this, About_Us.class);
                startActivity(intent);
            }
        });

        stu_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, StudentLoginActivity.class);
                startActivity(intent);
            }
        });

    }


}
