package com.example.android.studyapp.Tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android.studyapp.MainActivity;
import com.example.android.studyapp.R;
import com.example.android.studyapp.Tools.MemoryCards.CardMenu;
import com.example.android.studyapp.Tools.StudyTips.StudyTips;
import com.example.android.studyapp.Tools.Timer.TimerMenu;

public class ToolsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools_menu);
    }

    public void memoryClick (View view) {
        Intent i = new Intent(this, CardMenu.class);
        startActivity (i);
    }

    public void timerClick (View view) {
        Intent i = new Intent(this, TimerMenu.class);
        startActivity (i);
    }

    public void studyClick (View view) {
        Intent i = new Intent(this, StudyTips.class);
        startActivity (i);
    }

    public void brownNoiseClick (View view) {
        Intent i = new Intent(this, BrownNoise.class);
        startActivity (i);
    }

    public void toDoListClick (View view) {
        Intent i = new Intent(this, ToDoList.class);
        startActivity (i);
    }

    public void mainClick (View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity (i);
    }
}
