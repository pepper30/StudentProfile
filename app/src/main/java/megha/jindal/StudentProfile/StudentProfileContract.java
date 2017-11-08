package megha.jindal.StudentProfile;

import megha.jindal.FirebaseDatabase.DataInfo;

/**
 * Created by Megha Chauhan on 05-Nov-17.
 */

public interface StudentProfileContract {


    interface Presenter{
        void changePassword();
        void signOut();
    }

}
