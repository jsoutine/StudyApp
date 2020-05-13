package com.example.android.studyapp;

public class UserRequest {
    User user;
    String request;

    public UserRequest(User user, String request) {
        this.user = user;
        this.request = request;
    }

    public User getUser() {
        return user;
    }

    public String getRequest() {
        return request;
    }
}
