package com.example.android.studyapp;

public class UserThread extends Thread {
    User user;

    public UserThread(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        super.run();
    }
}