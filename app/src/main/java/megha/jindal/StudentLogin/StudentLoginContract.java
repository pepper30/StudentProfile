package megha.jindal.StudentLogin;

import megha.jindal.FirebaseDatabase.DataInfo;

/**
 * Created by Megha Chauhan on 04-Nov-17.
 */

public interface StudentLoginContract {


    interface View {
        String getEmail();
        String getPassword();
        String getRoll();
        void showToast(String message);
        void showProgressBar(Boolean show);
        void startProfileActivity(DataInfo dataInfo);

    }

    interface  Presenter{
        void loginClick();

    }

}
