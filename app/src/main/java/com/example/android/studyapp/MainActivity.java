package com.example.android.studyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.studyapp.Events.ViewCourses;
import com.example.android.studyapp.Tools.PersonalPage;
import com.example.android.studyapp.Tools.ToolsMenu;

import org.w3c.dom.Text;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    RandomQuoteGenerator randomQuoteGenerator = new RandomQuoteGenerator();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        TextView test = findViewById(R.id.testForUserLogin);
        String testar = DBConnector.loggedInUser.getFirstName();
        test.setText("Welcome " + testar + "!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "On Pause");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "On Resume");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "On Stop");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "On Start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "On Destroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "On Restart");
    }

    public void personalClick (View view) {
        Intent i = new Intent(this, PersonalPage.class);
        startActivity (i);
    }

    public void eventClick (View view) {
        Intent i = new Intent(this, ViewCourses.class);
        startActivity (i);
    }

    public void toolsClick (View view) {
        Intent i = new Intent(this, ToolsMenu.class);
        startActivity (i);
    }

    public void helpClick (View view) {
        Intent i = new Intent(this, Help.class);
        startActivity (i);
    }
    public void calendarClick (View view) {
        Intent i = new Intent(this, Calendar.class);
        startActivity (i);
    }
}
