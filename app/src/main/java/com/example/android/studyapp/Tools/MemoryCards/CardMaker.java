package com.example.android.studyapp.Tools.MemoryCards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.studyapp.R;

import java.util.ArrayList;
import java.util.List;

public class CardMaker extends AppCompatActivity {

    int i;
    String title;
    String subject;
    String question;
    String answer;
    static ArrayList<Card> deck = new ArrayList<Card>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_maker);

        Intent i = getIntent();
        title = i.getExtras().getString("title");
        subject = i.getExtras().getString("subject");

        TextView deckTextView = (TextView) findViewById(R.id.titleTextView);
        TextView deckTextView2 = (TextView) findViewById(R.id.subjectTextView);
        deckTextView.setText(title);
        deckTextView2.setText(subject);
    }

    public void addCardClick(View view){

        EditText questionEditText = (EditText) findViewById(R.id.questionEditText);
        EditText answerEditText = (EditText) findViewById(R.id.answerEditText);
        question = questionEditText.getText().toString();
        answer = answerEditText.getText().toString();

        deck.add(new Card(title, subject, question, answer));
    }
}
