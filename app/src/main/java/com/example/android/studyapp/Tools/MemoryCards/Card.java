package com.example.android.studyapp.Tools.MemoryCards;

public class Card {

    private String title;
    private String subject;
    private String question;
    private String answer;


    public Card(String title, String subject, String question, String answer){
        this.title = title;
        this.subject = subject;
        this.question = question;
        this. answer = answer;
    }

    public Card() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}