package com.example.android.studyapp.Tools.Timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android.studyapp.Help;
import com.example.android.studyapp.R;
import com.example.android.studyapp.Tools.ToolsMenu;

public class TimerMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_menu);
    }

    public void timerStartClick (View view) {
        Intent i = new Intent(this, Timer.class);
        startActivity (i);
    }

    public void toolsClick (View view) {
        Intent i = new Intent(this, ToolsMenu.class);
        startActivity (i);
    }
}
