package megha.jindal.StudentLogin;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.Serializable;

import megha.jindal.FirebaseDatabase.DataInfo;
import megha.jindal.MainActivity;
import megha.jindal.R;
import megha.jindal.StudentProfile.StudentProfileActivity;

public class StudentLoginActivity extends AppCompatActivity implements StudentLoginContract.View{
    StudentLoginContract.Presenter presenter;
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
    public void startProfileActivity(DataInfo dataInfo) {
         dataInfo=new DataInfo(dataInfo.getEmail(),dataInfo.getBranch(),dataInfo.getSname(),dataInfo.getCgpa(),dataInfo.getRoll());
         Intent intent=new Intent(StudentLoginActivity.this,StudentProfileActivity.class);
         intent.putExtra("info",dataInfo);
         startActivity(intent);

    }
}
