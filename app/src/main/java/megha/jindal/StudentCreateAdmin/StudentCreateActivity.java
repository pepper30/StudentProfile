package megha.jindal.StudentCreateAdmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import megha.jindal.R;

public class StudentCreateActivity extends AppCompatActivity  implements  StudentCreateContract.View{
    EditText roll,pass,mail,name,branch,cgpa;
    Button btn;
    ProgressBar progressBar;
    private StudentCreateContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_create);

        roll=findViewById(R.id.roll);
        pass=findViewById(R.id.pass);
        mail=findViewById(R.id.mail);
        name=findViewById(R.id.name);
        branch=findViewById(R.id.branch);
        cgpa=findViewById(R.id.cgpa);
        btn=findViewById(R.id.create);
        progressBar=findViewById(R.id.progress);

      ;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onStudentCreate();
                mail.setText(" ");
                pass.setText(" ");
                cgpa.setText(" ");
                roll.setText(" ");
                branch.setText(" ");
                name.setText(" ");

            }
        });
        presenter = new StudentCreatePresenter(this);

    }


    @Override
    public String getEmail() {
        return mail.getText().toString();
    }

    @Override
    public String getPassword() {
        return pass.getText().toString();
    }

    @Override
    public String getBranch() {
        return branch.getText().toString();
    }

    @Override
    public String getCgpa() {
       return cgpa.getText().toString();

    }

    @Override
    public String getSname() {
        return name.getText().toString();
    }

    @Override
    public String getRoll() {
        return roll.getText().toString();
    }

    @Override
    public String setCgpa(String s) {
        return " ";
    }

    @Override
    public String setEmail(String s) {
        return " ";
    }

    @Override
    public String setPassword(String s) {
        return" ";
    }

    @Override
    public String setBranch(String s) {
        return" ";
    }

    @Override
    public String setRoll(String s) {
        return null;
    }

    @Override
    public String setSname(String s) {
        return null;
    }

    @Override
    public void showProgressBar(Boolean show) {
         if(show){
             progressBar.setVisibility(View.VISIBLE);
         }
         else{
             progressBar.setVisibility(View.GONE);
         }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


}
