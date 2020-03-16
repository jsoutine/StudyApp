package com.example.android.studyapp.Events;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.studyapp.R;

import java.util.ArrayList;
import java.util.HashSet;

public class ViewCourses extends AppCompatActivity {

    int courseId;
    static ArrayList<String> myCourses = new ArrayList<String>();
    static ArrayAdapter<String> arrayAdapter;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events);

        sharedPreferences = getApplicationContext().getSharedPreferences
                ("com.example.android.studyapp.Events", Context.MODE_PRIVATE);

        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("myCourses", null);

        if (set == null) {
            myCourses.add("Example Course");
        } else {
            myCourses = new ArrayList<>(set);
        }

        final ListView eventListView = findViewById(R.id.eventListView);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, myCourses);

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

                                sharedPreferences = getApplicationContext().getSharedPreferences
                                        ("com.example.android.studyapp.Events", Context.MODE_PRIVATE);
                                HashSet<String> set = new HashSet<>(ViewCourses.myCourses);
                                sharedPreferences.edit().putStringSet("myCourses", set).apply();
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
