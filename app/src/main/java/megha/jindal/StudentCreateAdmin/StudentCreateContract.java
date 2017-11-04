package megha.jindal.StudentCreateAdmin;

/**
 * Created by Megha Chauhan on 02-Nov-17.
 */

public interface StudentCreateContract {
    interface view{
        String getEmail();
        String getPassword();
        String getBranch();
        float getCgpa();
        String getSname();
        String getRoll();
        Float setCgpa(String s);
        String setEmail(String s);
        String setPassword(String s);
        String setBranch(String s);
        String setRoll(String s);
        String setSname(String s);
        void showProgressBar(Boolean show);
        void showToast(String message);

    }
    interface  presenter{
        void onStudentCreate();


    }
}
