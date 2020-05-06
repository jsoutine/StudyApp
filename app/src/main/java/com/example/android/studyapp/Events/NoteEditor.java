package com.example.android.studyapp.Events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.studyapp.Calendar;
import com.example.android.studyapp.MainActivity;
import com.example.android.studyapp.R;

import java.util.HashSet;

import static com.example.android.studyapp.Events.CourseNotes.notes;

public class NoteEditor extends AppCompatActivity {

    int noteId;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        EditText editText = findViewById(R.id.editText);
        Button saveButton = findViewById(R.id.saveButton);

        Button saveToCalendarBtn = findViewById(R.id.saveToCalBtn);
        saveToCalendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToCalendar();
            }
        });

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1) {
            editText.setText(notes.get(noteId));
        } else {
            notes.add("");
            noteId = notes.size() - 1;
        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                notes.set(noteId, String.valueOf(charSequence));
                CourseNotes.arrayAdapter.notifyDataSetChanged();

                sharedPreferences = getApplicationContext().getSharedPreferences
                        ("com.example.android.studyapp.Events", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<>(notes);
                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void saveButtonPressed(View view) {
        finish();
    }

    public void saveToCalendar() {
        finish();
        Intent i = new Intent(this, Calendar.class);
        i.putExtra("EVENT_MESSAGE", notes.get(noteId));
        startActivity(i);
    }
}

