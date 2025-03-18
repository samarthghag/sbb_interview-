package com.ssb.model;

public class User {
    private String fullName, aadhar, pan, phone, email, password, subject;

    // Constructor for minimal user details
    public User(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    // Constructor for full user details
    public User(String fullName, String aadhar, String pan, String phone, String email, String password, String subject) {
        this.fullName = fullName;
        this.aadhar = aadhar;
        this.pan = pan;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.subject = subject;
    }

    // Getters
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getAadhar() { return aadhar; }
    public String getPan() { return pan; }
    public String getPhone() { return phone; }
    public String getPassword() { return password; }
    public String getSubject() { return subject; }

    // Setters
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setAadhar(String aadhar) { this.aadhar = aadhar; }
    public void setPan(String pan) { this.pan = pan; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setPassword(String password) { this.password = password; }
    public void setSubject(String subject) { this.subject = subject; }
}
