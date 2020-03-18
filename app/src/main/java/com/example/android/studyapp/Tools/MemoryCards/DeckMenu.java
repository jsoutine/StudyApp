package com.example.android.studyapp.Tools.MemoryCards;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.studyapp.Events.CourseNotes;
import com.example.android.studyapp.Events.ViewCourses;
import com.example.android.studyapp.R;

import java.util.ArrayList;
import java.util.HashSet;

public class DeckMenu extends AppCompatActivity {

    int deckId;
    static ArrayList<String> myDecks = new ArrayList<String>();
    static ArrayList<Card> cardDeck = new ArrayList<Card>();
    static ArrayAdapter<String> arrayAdapter;
    static ArrayAdapter<Card> arrayAdapter2;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_menu);

        sharedPreferences = getApplicationContext().getSharedPreferences
                ("com.example.android.Tools.MemoryCards", Context.MODE_PRIVATE);

        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("myDecks", null);

        if (set == null) {
            myDecks.add("Example Deck");
        } else {
            myDecks = new ArrayList<>(set);
        }

        final ListView deckListView = findViewById(R.id.deckListView);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, myDecks);

        deckListView.setAdapter(arrayAdapter);

        deckListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String deckId = (String) deckListView.getItemAtPosition(i);
                Intent intent = new Intent(getApplicationContext(), MyCards.class);
                intent.putExtra("deckId", deckId);
                startActivity(intent);
            }
        });

        deckListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int itemToDelete = i;

                new AlertDialog.Builder(DeckMenu.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this deck?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                myDecks.remove(itemToDelete);
                                arrayAdapter.notifyDataSetChanged();

                                sharedPreferences = getApplicationContext().getSharedPreferences
                                        ("com.example.android.studyapp.Events", Context.MODE_PRIVATE);
                                HashSet<String> set = new HashSet<>(myDecks);
                                sharedPreferences.edit().putStringSet("myDecks", set).apply();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
        });
    }

    public void createCardClick (View view) {
        Intent i = new Intent(this, CreateDeck.class);
        startActivity (i);
    }
}
