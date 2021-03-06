package com.example.android.studyapp.Tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.studyapp.MainActivity;
import com.example.android.studyapp.R;
import com.example.android.studyapp.Tools.MemoryCards.CardMenu;
import com.example.android.studyapp.Tools.StudyTips.StudyTips;
import com.example.android.studyapp.Tools.Timer.TimerMenu;

import java.util.Objects;

public class ToolsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_tools_menu);

        Button timerBtnTool = (Button) findViewById(R.id.btnTimerTool);

        timerBtnTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerClick(view);
            }
        });
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
