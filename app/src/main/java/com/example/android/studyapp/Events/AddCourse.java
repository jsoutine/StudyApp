package com.example.android.studyapp.Events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.android.studyapp.MainActivity;
import com.example.android.studyapp.R;

public class AddCourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_menu);
    }

    public void store(){
        EditText courseNameText = (EditText) findViewById(R.id.courseNameText);
        EditText subjectNameText = (EditText) findViewById(R.id.subjectNameText);
        EditText startDateText = (EditText) findViewById(R.id.startDateText);
        EditText endDateText = (EditText) findViewById(R.id.endDateText);
    }
}
