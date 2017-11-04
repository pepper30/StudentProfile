package megha.jindal.AdminCreateAccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import io.reactivex.Completable;
import megha.jindal.AdminLogin.LoginActivity;
import megha.jindal.R;
import megha.jindal.firebase.Data;
import megha.jindal.firebase.FireBaseAuthen;

public class CreateAccountActivity extends AppCompatActivity implements CreateAccountContract.view {

    EditText pass, email;
    ProgressBar progressBar;
    Button signup_btn;

    private CreateAccountContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        presenter = new CreateAccountPresenter(this);

        pass = findViewById(R.id.password);
        email = findViewById(R.id.email);
        signup_btn = findViewById(R.id.signup);
        progressBar = findViewById(R.id.progress);


        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.OnCreateClick();
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
    public void showProgressbar(Boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
