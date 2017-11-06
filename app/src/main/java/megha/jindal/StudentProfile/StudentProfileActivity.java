package megha.jindal.StudentProfile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import megha.jindal.FirebaseDatabase.DataInfo;
import megha.jindal.R;
import megha.jindal.firebase.Data;

public class StudentProfileActivity extends AppCompatActivity {
    StudentProfileContract.Presenter presenter;


    TextView name,roll,cgpa,branch,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        name=findViewById(R.id.name);
        roll=findViewById(R.id.roll);
        cgpa=findViewById(R.id.cgpa);
        branch=findViewById(R.id.branch);
        email=findViewById(R.id.mail);




        DataInfo dataInfo=(DataInfo)getIntent().getSerializableExtra("info");
        name.setText(dataInfo.getSname());
        email.setText(dataInfo.getEmail());
        roll.setText(dataInfo.getRoll());
        cgpa.setText( dataInfo.getCgpa());
        branch.setText(dataInfo.getBranch());
    }



}
