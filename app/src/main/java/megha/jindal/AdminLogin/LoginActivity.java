package megha.jindal.AdminLogin;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import megha.jindal.AdminCreateAccount.CreateAccountActivity;
import megha.jindal.R;
import megha.jindal.StudentCreateAdmin.StudentCreateActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    EditText pass,email;
    ProgressBar progressBar;
    Button login_btn,signup_btn;

    private LoginContract.Presenter presenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter=new LoginPresenter(this);

        pass=findViewById(R.id.password);
        email=findViewById(R.id.email);
        progressBar=findViewById(R.id.progress);
        progressBar.setBackgroundColor(Color.BLACK);
        login_btn=findViewById(R.id.login);
        signup_btn=findViewById(R.id.signup);

       login_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             presenter.onLogin();
           }
       });

       signup_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               createAccountActivity();
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
    public void showProgressBar(Boolean show)
    {
        if(show)
            progressBar.setVisibility(View.VISIBLE);

            else
                progressBar.setVisibility(View.GONE);

        }


    @Override
    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void studentCreateActivity() {
       Intent intent=new Intent(this,StudentCreateActivity.class);
            startActivity(intent);
        }

    @Override
    public void createAccountActivity() {
        Intent intent=new Intent(this,CreateAccountActivity.class);
          startActivity(intent);
        }

    }







