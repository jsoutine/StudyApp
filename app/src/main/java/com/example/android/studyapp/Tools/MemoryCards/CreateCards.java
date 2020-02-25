package com.example.android.studyapp.Tools.MemoryCards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.android.studyapp.R;

public class CreateCards extends AppCompatActivity {

    public void generateDeck(View view) {

        EditText titleText = (EditText) findViewById(R.id.titleText);
        EditText subjectText = (EditText) findViewById(R.id.subjectText);

        String title = titleText.getText().toString();
        String subject = subjectText.getText().toString();

        Intent i = new Intent(this, cardMaker.class);
        i.putExtra("title", title);
        i.putExtra("subject", subject);
        startActivity (i);

        Log.i("Entered title", titleText.getText().toString());
        Log.i("Entered subject", subjectText.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cards);
    }
}
