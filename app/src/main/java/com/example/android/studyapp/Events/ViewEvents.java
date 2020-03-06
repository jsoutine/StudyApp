package com.example.android.studyapp.Events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.studyapp.R;

import java.util.ArrayList;

public class ViewEvents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events);

        ListView eventListView = findViewById(R.id.eventListView);

        final ArrayList<String> myCourses = new ArrayList<String>();

        myCourses.add("Maths");
        myCourses.add("Computer Networks");
        myCourses.add("Android");
        myCourses.add("Java 101");
        myCourses.add("Horse Taming");
        myCourses.add("Maths");
        myCourses.add("Computer Networks");
        myCourses.add("Android");
        myCourses.add("Java 101");
        myCourses.add("Horse Taming");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, myCourses);

        eventListView.setAdapter(arrayAdapter);

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.i("Course selected", myCourses.get(i));
            }
        });
    }
}
