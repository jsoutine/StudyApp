package com.example.android.studyapp;

public class User {
    private int userID;
    private String username;
    private String email;
    private String password;
    private String calenderAddress;

    public User(int userID, String username, String email, String password, String calenderAddress) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.calenderAddress = calenderAddress;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getCalenderAddress() {
        return calenderAddress;
    }

    public void setCalenderAddress(String calenderAddress) {
        this.calenderAddress = calenderAddress;
    }
}
