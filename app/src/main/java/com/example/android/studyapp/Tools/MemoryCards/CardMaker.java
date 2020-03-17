package com.example.android.studyapp.Tools.MemoryCards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.studyapp.Events.CourseNotes;
import com.example.android.studyapp.Events.ViewCourses;
import com.example.android.studyapp.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CardMaker extends AppCompatActivity {

    int deckId;
    String title;
    String subject;
    String question;
    String answer;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_maker);



        Intent i = getIntent();
        title = i.getExtras().getString("title");
        subject = i.getExtras().getString("subject");
        deckId = i.getIntExtra("deckId", -1);


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

        Intent intent = new Intent(getApplicationContext(), DeckMenu.class);
        intent.putExtra("answer", answer);
        intent.putExtra("question", question);
        intent.putExtra("title", title);
        intent.putExtra("subject", subject);


        DeckMenu.myDecks.set(deckId, question);
        DeckMenu.arrayAdapter.notifyDataSetChanged();

        sharedPreferences = getApplicationContext().getSharedPreferences
                ("com.example.android.studyapp.Tools.MemoryCards", Context.MODE_PRIVATE);
        HashSet<String> set = new HashSet<>(DeckMenu.myDecks);
        sharedPreferences.edit().putStringSet("myDecks", set).apply();
        startActivity(intent);
    }
}
