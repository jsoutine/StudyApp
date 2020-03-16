package com.example.android.studyapp.Events;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.studyapp.R;

import java.util.ArrayList;

public class ViewCourses extends AppCompatActivity {

    static ArrayList<String> myCourses = new ArrayList<String>();
    static ArrayAdapter<String> arrayAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events);

        final ListView eventListView = findViewById(R.id.eventListView);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, myCourses);

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

        eventListView.setAdapter(arrayAdapter);

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String courseId = (String) eventListView.getItemAtPosition(i);
                Intent intent = new Intent(getApplicationContext(), CourseNotes.class);
                intent.putExtra("courseId", courseId);
                startActivity(intent);
            }
        });

       eventListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int itemToDelete = i;

                new AlertDialog.Builder(ViewCourses.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this course?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                myCourses.remove(itemToDelete);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
        });
    }

    public void addCourseClick (View view) {
        Intent i = new Intent(this, AddCourse.class);
        startActivity (i);
    }
}
