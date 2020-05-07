package com.example.android.studyapp.Tools;

public class UserInformation {

    private String username;
    private String latestResults;
    private String totalResults;
    private String completedTimer;
    private String interruptedTimer;

    public UserInformation (String username, String latestResults, String totalResults,
                            String completedTimer, String interruptedTimer){
        this.username = username;
        this.latestResults = latestResults;
        this.totalResults = totalResults;
        this.completedTimer = completedTimer;
        this.interruptedTimer = interruptedTimer;
    }




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLatestResults() {
        return latestResults;
    }

    public void setLatestResults(String latestResults) {
        this.latestResults = latestResults;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getCompletedTimer() {
        return completedTimer;
    }

    public void setCompletedTimer(String completedTimer) {
        this.completedTimer = completedTimer;
    }

    public String getInterruptedTimer() {
        return interruptedTimer;
    }

    public void setInterruptedTimer(String interruptedTimer) {
        this.interruptedTimer = interruptedTimer;
    }
}
