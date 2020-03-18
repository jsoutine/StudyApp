package com.example.android.studyapp.Tools.MemoryCards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    EditText questionEditText;
    EditText answerEditText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_maker);

        questionEditText = (EditText) findViewById(R.id.questionEditText);
        answerEditText = (EditText) findViewById(R.id.answerEditText);
        
        Intent i = getIntent();
        title = i.getExtras().getString("title");
        subject = i.getExtras().getString("subject");
        deckId = i.getIntExtra("deckId", -1);

        if (deckId != -1) {
            answerEditText.setText(DeckMenu.myDecks.get(deckId));
        } else {
            DeckMenu.myDecks.add("");
            deckId = DeckMenu.myDecks.size() - 1;
        }


        TextView deckTextView = (TextView) findViewById(R.id.titleTextView);
        TextView deckTextView2 = (TextView) findViewById(R.id.subjectTextView);
        deckTextView.setText(title);
        deckTextView2.setText(subject);
    }

    public void addCardClick(View view){

        Intent intent = new Intent(getApplicationContext(), DeckMenu.class);


        question = questionEditText.getText().toString();
        answer = answerEditText.getText().toString();

        Card card = new Card(title, subject, question, answer);

        DeckMenu.cardDeck.add(card);;

        DeckMenu.myDecks.set(deckId, title);
        //DeckMenu.arrayAdapter.notifyDataSetChanged();

        sharedPreferences = getApplicationContext().getSharedPreferences
                ("com.example.android.studyapp.Tools.MemoryCards", Context.MODE_PRIVATE);
        HashSet<String> set = new HashSet<>(DeckMenu.myDecks);
        sharedPreferences.edit().putStringSet("myDecks", set).apply();

        Toast toast = Toast.makeText(this, "Card Added!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        questionEditText.setText("");
        answerEditText.setText("");
    }

    public void doneDeckButton(View view) {
        Intent intent = new Intent(getApplicationContext(), DeckMenu.class);
        startActivity(intent);
    }
}
