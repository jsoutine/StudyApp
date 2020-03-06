package com.example.android.studyapp.Events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.studyapp.R;

import java.util.ArrayList;

public class ViewCourses extends AppCompatActivity {

    ArrayList<String> myCourses = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events);

        final ListView eventListView = findViewById(R.id.eventListView);

        myCourses.add("Maths");
        myCourses.add("Computer Networks");
        myCourses.add("Android");
        myCourses.add("Java 101");
        myCourses.add("Horse Taming");
        myCourses.add("Psychology Introduction");
        myCourses.add("Fundamental Philosophy");
        myCourses.add("Greek Verbs and their influence on Roman mythology");
        myCourses.add("International Relations");
        myCourses.add("Spycraft 201");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, myCourses);

        eventListView.setAdapter(arrayAdapter);

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String courseId = (String) eventListView.getItemAtPosition(i);
                Intent intent = new Intent(getApplicationContext(),CourseWindow.class);
                intent.putExtra("courseId", courseId);
                startActivity(intent);
            }
        });
    }

    public void addCourseClick (View view) {
        Intent i = new Intent(this, AddCourse.class);
        startActivity (i);
    }
}
