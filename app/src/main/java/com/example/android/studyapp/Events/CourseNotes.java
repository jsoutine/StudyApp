package com.example.android.studyapp.Events;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.studyapp.R;

import java.util.ArrayList;
import java.util.HashSet;

public class CourseNotes extends AppCompatActivity {

    static ArrayList<String> notes = new ArrayList<String>();
    static ArrayAdapter arrayAdapter;
    SharedPreferences sharedPreferences;
    String courseName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_window);

        sharedPreferences = getApplicationContext().getSharedPreferences
                ("com.example.android.studyapp.Events", Context.MODE_PRIVATE);

        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("notes", null);

        if (set == null) {
            notes.add("Example Note");
        } else {
            notes = new ArrayList<>(set);
        }

        courseInfo();

        ListView notesListView = findViewById(R.id.notesListView);
        notes.add(courseName + " note");
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);
        notesListView.setAdapter(arrayAdapter);

        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), NoteEditor.class);
                intent.putExtra("noteId", i);
                startActivity(intent);
            }
        });

        notesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int itemToDelete = i;

                new AlertDialog.Builder(CourseNotes.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this note?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                notes.remove(itemToDelete);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();

                sharedPreferences = getApplicationContext().getSharedPreferences
                        ("com.example.android.studyapp.Events", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<>(notes);
                sharedPreferences.edit().putStringSet("notes", set).apply();

                return true;
            }
        });
    }

    public void courseInfo() {
        Intent i = getIntent();
        courseName = i.getExtras().getString("courseId");
        TextView courseText = (TextView) findViewById(R.id.courseTextView);
        courseText.setText(courseName);
    }

    //MENU

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuinflater = getMenuInflater();
        menuinflater.inflate(R.menu.add_note_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.add_note) {
            Intent intent = new Intent(getApplicationContext(), NoteEditor.class);
            startActivity(intent);

            return true;
        }

        return false;
    }

    public void addNote(View view){
        Intent intent = new Intent(getApplicationContext(), NoteEditor.class);
        startActivity(intent);
    }
}
