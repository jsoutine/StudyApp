package com.example.android.studyapp.Events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.studyapp.MainActivity;
import com.example.android.studyapp.R;

import java.util.ArrayList;
import java.util.HashSet;

public class AddCourse extends AppCompatActivity {
    int courseId;
    EditText courseNameText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_menu);

        courseNameText = findViewById(R.id.courseNameText);
        EditText subjectNameText = (EditText) findViewById(R.id.subjectNameText);

        Intent intent = getIntent();
        courseId = intent.getIntExtra("courseId", -1);

        if (courseId != -1) {
            courseNameText.setText(ViewCourses.myCourses.get(courseId));
        } else {
            ViewCourses.myCourses.add("");
            courseId = ViewCourses.myCourses.size() - 1;
        }

        courseNameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ViewCourses.myCourses.set(courseId, String.valueOf(charSequence));
                ViewCourses.arrayAdapter.notifyDataSetChanged();

                sharedPreferences = getApplicationContext().getSharedPreferences
                        ("com.example.android.studyapp.Events", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<>(ViewCourses.myCourses);
                sharedPreferences.edit().putStringSet("myCourses", set).apply();
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void addCourseButton(View view) {
        if (courseNameText.getText().toString().equals("")) {
            Toast toast = Toast.makeText(this, "You didn't enter a course", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

        sharedPreferences = getApplicationContext().getSharedPreferences
                ("com.example.android.studyapp.Events", Context.MODE_PRIVATE);

        finish();
    }
}

