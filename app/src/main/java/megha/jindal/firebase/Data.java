package megha.jindal.firebase;

import java.security.SecureRandom;

/**
 * Created by Megha Chauhan on 15-Oct-17.
 */

public class Data {
    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Data(String mail, String pass){
        this.email=mail;
        this.password=pass;
    }


}
