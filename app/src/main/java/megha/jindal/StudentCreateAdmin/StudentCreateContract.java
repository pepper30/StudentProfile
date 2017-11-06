package megha.jindal.StudentCreateAdmin;

/**
 * Created by Megha Chauhan on 02-Nov-17.
 */

public interface StudentCreateContract {
    interface View{
        String getEmail();
        String getPassword();
        String getBranch();
        String getCgpa();
        String getSname();
        String getRoll();
        String setCgpa(String s);
        String setEmail(String s);
        String setPassword(String s);
        String setBranch(String s);
        String setRoll(String s);
        String setSname(String s);
        void showProgressBar(Boolean show);
        void showToast(String message);

    }
    interface  Presenter{
        void onStudentCreate();


    }
}
