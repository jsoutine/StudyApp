package com.example.android.studyapp.Events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android.studyapp.MainActivity;
import com.example.android.studyapp.R;

public class EventsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_menu);
    }

    public void createClick (View view) {
        Intent i = new Intent(this, CreateEvent.class);
        startActivity (i);
    }

    public void viewClick (View view) {
        Intent i = new Intent(this, ViewEvents.class);
        startActivity (i);
    }

    public void mainClick (View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity (i);
    }
}
