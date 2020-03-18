package com.example.android.studyapp.Tools.MemoryCards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.studyapp.R;
import com.example.android.studyapp.RandomQuoteGenerator;
import com.example.android.studyapp.Tools.ToolsMenu;

public class CardMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_menu);
        quote();
    }

    public void quote(){
        TextView quoteTextView = (TextView) findViewById(R.id.quoteTextView);
        quoteTextView.setText(RandomQuoteGenerator.quoteGenerator());
    }

    public void createCardClick (View view) {
        Intent i = new Intent(this, CreateDeck.class);
        startActivity (i);
    }

    public void myClick (View view) {
        Intent i = new Intent(this, DeckMenu.class);
        startActivity (i);
    }

    public void backClick (View view) {
        Intent i = new Intent(this, ToolsMenu.class);
        startActivity (i);
    }
}
