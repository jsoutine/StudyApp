package com.example.android.studyapp.Tools.MemoryCards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.studyapp.Events.EventsMenu;
import com.example.android.studyapp.R;

public class cardMaker extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_maker);

        Intent i = getIntent();
        String title = i.getExtras().getString("title");
        String subject = i.getExtras().getString("subject");

        TextView deckTextView = (TextView) findViewById(R.id.deckTextView);
        TextView deckTextView2 = (TextView) findViewById(R.id.deckTextView2);
        deckTextView.setText(title);
        deckTextView2.setText(subject);
    }
}
