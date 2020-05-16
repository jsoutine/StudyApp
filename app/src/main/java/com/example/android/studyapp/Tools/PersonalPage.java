package com.example.android.studyapp.Tools;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.studyapp.Calendar;
import com.example.android.studyapp.DBConnector;
import com.example.android.studyapp.R;
import com.example.android.studyapp.User;

import java.util.ArrayList;

public class PersonalPage extends AppCompatActivity {

    ArrayList<String> myEvents = new ArrayList<String>();
    ArrayList<String> myTasks = new ArrayList<String>();
    ArrayAdapter<String> eventsAdapter;
    ArrayAdapter<String> tasksAdapter;
    DBConnector dbConnector = new DBConnector();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_page);

        TextView userName = (TextView) findViewById(R.id.textUserName);
        TextView newResults = (TextView) findViewById(R.id.textNewResults);
        TextView totalResults = (TextView) findViewById(R.id.textTotalDeck);
        TextView completedTimer = (TextView) findViewById(R.id.textCompleteTimer);
        TextView interruptedTimer = (TextView) findViewById(R.id.textInterruptTimer);
        final ListView eventsList = (ListView) findViewById(R.id.eventsList);
        final ListView tasksList = (ListView) findViewById(R.id.taskList);

        String username;
        String email;


        //these values are placeholders, information will be fetched from the database.
        //UserInformation userInformation = new UserInformation("John Userson", "7 out of 9 correct",
        //        "65 out of 78 correct", "6 complete timers", "3 interrupted timers");

        userName.setText(DBConnector.loggedInUser.getFirstName() + " " + DBConnector.loggedInUser.getLastName());
        //newResults.setText(userInformation.getLatestResults());
        //totalResults.setText(userInformation.getTotalResults());
        //completedTimer.setText(userInformation.getCompletedTimer());
        //interruptedTimer.setText(userInformation.getInterruptedTimer());

        //these are placeholders, actual list will be imported from classes
        myEvents.add("Meeting with Sarah Connor");
        myEvents.add("Kindergarten planning");
        myEvents.add("Spanish class");
        myEvents.add("Judgement Day");

        myTasks.add("Do laundry");
        myTasks.add("Take out trash");
        myTasks.add("Learn nuclear physics");
        myTasks.add("Wash horse");

        eventsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, myEvents);

        eventsList.setAdapter(eventsAdapter);

        eventsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String eventId = (String) eventsList.getItemAtPosition(i);
                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                intent.putExtra("eventId", eventId);
                startActivity(intent);
            }
        });

        tasksAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, myTasks);

        tasksList.setAdapter(tasksAdapter);

        tasksList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String taskId = (String) tasksList.getItemAtPosition(i);
                Intent intent = new Intent(getApplicationContext(), ToDoList.class);
                intent.putExtra("taskId", taskId);
                startActivity(intent);
            }
        });
    }
}
