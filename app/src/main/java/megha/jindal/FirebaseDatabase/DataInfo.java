package megha.jindal.FirebaseDatabase;

import java.io.Serializable;

/**
 * Created by Megha Chauhan on 01-Nov-17.
 */

public class DataInfo implements Serializable {

    public String getEmail() {
        return email;
    }

    public  String getPassword() {
        return password;
    }



    public String getBranch() {
        return branch;
    }

    public String getSname() {
        return sname;
    }

    public String getCgpa() {
        return cgpa;
    }

    public  String getRoll() {
        return roll;
    }

    String roll,email,password,branch,sname;
    String cgpa;

    public  DataInfo(String email,String pass,String roll){
        this.email=email;
        this.roll=roll;
        this.password=pass;
    }


    public DataInfo(String email,String pass,String br,String name,String cgpa,String roll){
        this.branch=br;
        this.cgpa=cgpa;
        this.email=email;
        this.password=pass;
        this.sname=name;
        this.roll=roll;
    }

    public DataInfo(){}

    public DataInfo(String email,String br,String name,String cgpa,String roll){
        this.branch=br;
        this.cgpa=cgpa;
        this.email=email;
        this.sname=name;
        this.roll=roll;
    }

    @Override
    public String toString() {
        return "Email:" + this.getEmail() ;
    }
}
