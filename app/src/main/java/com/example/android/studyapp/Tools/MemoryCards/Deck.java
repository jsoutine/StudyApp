package com.example.android.studyapp.Tools.MemoryCards;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private String title;
    private String subject;

    public Deck(String title, String subject) {
        this.title = title;
        this.subject = subject;

        List<Card> deck = new ArrayList<Card>();
    }
}
