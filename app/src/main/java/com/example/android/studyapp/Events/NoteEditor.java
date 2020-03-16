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

import com.example.android.studyapp.MainActivity;
import com.example.android.studyapp.R;

import java.util.HashSet;

public class NoteEditor extends AppCompatActivity {

    int noteId;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        EditText editText = findViewById(R.id.editText);
        Button saveButton = findViewById(R.id.saveButton);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1) {
            editText.setText(CourseNotes.notes.get(noteId));
        } else {
            CourseNotes.notes.add("");
            noteId = CourseNotes.notes.size() - 1;
        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                CourseNotes.notes.set(noteId, String.valueOf(charSequence));
                CourseNotes.arrayAdapter.notifyDataSetChanged();

                sharedPreferences = getApplicationContext().getSharedPreferences
                        ("com.example.android.studyapp.Events", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<>(CourseNotes.notes);
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
}

