package megha.jindal.StudentProfile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import megha.jindal.FaqActivity;
import megha.jindal.FirebaseDatabase.DataInfo;
import megha.jindal.R;
import megha.jindal.RecruitActivity;
import megha.jindal.firebase.Data;

public class StudentProfileActivity extends AppCompatActivity {
    StudentProfileContract.Presenter presenter;


    TextView name,roll,cgpa,branch,email;
    Button recruiter,faq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        recruiter=findViewById(R.id.re);
        faq=findViewById(R.id.faq);
        name=findViewById(R.id.name);
        roll=findViewById(R.id.roll);
        cgpa=findViewById(R.id.cgpa);
        branch=findViewById(R.id.branch);
        email=findViewById(R.id.mail);

        final Intent intent=getIntent();
        final DataInfo dataInfo=(DataInfo)intent.getSerializableExtra("info");
        name.setText("Name : "+dataInfo.getSname());
        roll.setText("Roll No. :"+dataInfo.getRoll());
        cgpa.setText("CGPA : "+dataInfo.getCgpa());
        branch.setText("Branch : "+dataInfo.getBranch());
        email.setText("Email : "+dataInfo.getEmail());

        recruiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog  dialog=new ProgressDialog(StudentProfileActivity.this);
                dialog.setMessage("please wait");
                Intent intent1=new Intent(StudentProfileActivity.this,RecruitActivity.class);
                startActivity(intent1);
            }
        });

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog dialog=new ProgressDialog(StudentProfileActivity.this);
                dialog.setMessage("please wait");
                Intent intent2=new Intent(StudentProfileActivity.this,FaqActivity.class);
                startActivity(intent2);
            }
        });


    }



}
