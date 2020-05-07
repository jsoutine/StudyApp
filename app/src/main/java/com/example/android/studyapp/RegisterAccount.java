package com.example.android.studyapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterAccount extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText usernameEditText = findViewById(R.id.usernameTextField);
        final EditText passwordEditText = findViewById(R.id.regPW);
        final EditText verPasswordEditText = findViewById(R.id.verRegPW);
        final Button regButton = findViewById(R.id.createAccButton);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}
