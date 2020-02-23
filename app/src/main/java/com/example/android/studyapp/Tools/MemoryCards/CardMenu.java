package com.example.android.studyapp.Tools.MemoryCards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android.studyapp.R;
import com.example.android.studyapp.Tools.ToolsMenu;

public class CardMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_menu);
    }

    public void createCardClick (View view) {
        Intent i = new Intent(this, CreateCards.class);
        startActivity (i);
    }

    public void myClick (View view) {
        Intent i = new Intent(this, MyCards.class);
        startActivity (i);
    }

    public void backClick (View view) {
        Intent i = new Intent(this, ToolsMenu.class);
        startActivity (i);
    }
}
