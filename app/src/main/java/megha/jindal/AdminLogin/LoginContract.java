package megha.jindal.AdminLogin;

/**
 * Created by Megha Chauhan on 17-Oct-17.
 */

public interface LoginContract {
    interface view{
        String getEmail();
        String getPassword();
        void showProgressBar(Boolean show);
        void showToast(String  message);
        void StudentCreateActivity();
        void CreateAccountActivity();
    }

    interface  presenter{
        void onLogin();
    }


}
