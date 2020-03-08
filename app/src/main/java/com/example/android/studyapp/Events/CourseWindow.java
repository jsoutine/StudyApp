package com.example.android.studyapp.Events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.studyapp.R;

public class CourseWindow extends AppCompatActivity {

    String courseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_window);

        courseInfo();
    }

    public void courseInfo(){
        Intent i = getIntent();
        courseName = i.getExtras().getString("courseId");
        TextView courseText = (TextView) findViewById(R.id.courseTextView);
        courseText.setText(courseName);
    }
}
