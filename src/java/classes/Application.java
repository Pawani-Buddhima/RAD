package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {
    private int app_id;
    private int job_seeker_id;
    private String first_name;
    private String last_name;
    private String email;
    private String mobile;
    private Date dob;
    private byte[] resume;

    public Application(int app_id, int job_seeker_id, String first_name, String last_name, String email, String mobile, Date dob, byte[] resume) {
        this.app_id = app_id;
        this.job_seeker_id = job_seeker_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;
        this.resume = resume;
    }

    public Application() {
        
    }

    public int getAppId() {
        return app_id;
    }

    public void setAppId(int app_id) {
        this.app_id = app_id;
    }

    public int getJobSeekerId() {
        return job_seeker_id;
    }

    public void setJobSeekerId(int job_seeker_id) {
        this.job_seeker_id = job_seeker_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }

    void add(Application application) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    }
    

