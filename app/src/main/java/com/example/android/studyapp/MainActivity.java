package com.example.android.studyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android.studyapp.Events.ViewCourses;
import com.example.android.studyapp.Tools.ToolsMenu;

public class MainActivity extends AppCompatActivity {

    RandomQuoteGenerator randomQuoteGenerator = new RandomQuoteGenerator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void eventClick (View view) {
        Intent i = new Intent(this, ViewCourses.class);
        startActivity (i);
    }

    public void toolsClick (View view) {
        Intent i = new Intent(this, ToolsMenu.class);
        startActivity (i);
    }

    public void helpClick (View view) {
        Intent i = new Intent(this, Help.class);
        startActivity (i);
    }
    public void calendarClick (View view) {
        Intent i = new Intent(this, Calendar.class);
        startActivity (i);
    }
}
