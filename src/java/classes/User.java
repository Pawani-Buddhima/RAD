package classes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;  // "admin", "job_seeker", "recruiter"
    private String dob;   // Date of Birth (you can use String or java.util.Date)
    private String address;
    private String mobile;
    private String nic;
    
    // Constructors
    public User() {
        // Default constructor
    }
    
    public User(int id, String firstName, String lastName, String email, String password, String role, String dob, String address, String mobile, String nic) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.dob = dob;
        this.address = address;
        this.mobile = mobile;
        this.nic = nic;
    }

    public User(int aInt, String string, String string0, String string1, String string2, String string3, String string4, String string5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Getters and setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getDOB() {
        return dob;
    }
    
    public void setDOB(String dob) {
        this.dob = dob;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getNIC() {
        return nic;
    }
    
    public void setNIC(String nic) {
        this.nic = nic;
    }
    public static String hashPassword(String passwordText){
        
        String hash = null;
        
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");

            md.update(passwordText.getBytes());

            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            hash = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(hash);
        return hash;
    }
    
    public boolean validatePassword(String inputPassword) {
    // Check if inputPassword meets certain criteria, such as length, complexity, etc.
    if (inputPassword.length() < 8) {
        return false; 
    }

    boolean containsUppercase = !inputPassword.equals(inputPassword.toLowerCase());
    boolean containsLowercase = !inputPassword.equals(inputPassword.toUpperCase());
    boolean containsDigit = inputPassword.matches(".*\\d.*");
    boolean containsSpecialChar = !inputPassword.matches("[a-zA-Z0-9]*");

    if (!(containsUppercase && containsLowercase && containsDigit && containsSpecialChar)) {
        return false; // Password does not meet complexity requirements
    }
    
    return password.equals(inputPassword);
}

    
}

