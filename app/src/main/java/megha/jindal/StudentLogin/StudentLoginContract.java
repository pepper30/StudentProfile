package megha.jindal.StudentLogin;

/**
 * Created by Megha Chauhan on 04-Nov-17.
 */

public interface StudentLoginContract {
    interface view {
        String getEmail();
        String getPassword();
        String getRoll();
        void showToast(String message);
        void showProgressBar(Boolean show);
        void startProfileActivity();

    }

    interface  presenter{
        void loginClick();

    }

}
