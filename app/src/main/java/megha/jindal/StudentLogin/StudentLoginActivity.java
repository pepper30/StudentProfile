package megha.jindal.StudentLogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import megha.jindal.MainActivity;
import megha.jindal.R;

public class StudentLoginActivity extends AppCompatActivity implements StudentLoginContract.view{
    StudentLoginContract.presenter presenter;
    EditText email,pass,roll;
    ProgressBar progressBar;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        roll=findViewById(R.id.roll);
        progressBar=findViewById(R.id.progress);
        btn=findViewById(R.id.login);

        presenter=new StudentLoginPresenter(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginClick();

            }
        });
    }


    @Override
    public String getEmail() {
        return email.getText().toString();
    }

    @Override
    public String getPassword() {
        return pass.getText().toString();
    }

    @Override
    public String getRoll() {
        return roll.getText().toString();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar(Boolean show) {
        if(show) {
            progressBar.setVisibility(View.VISIBLE);
        }
        else{
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void startProfileActivity() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
