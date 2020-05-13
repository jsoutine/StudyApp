package com.example.android.studyapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterAccount extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText usernameEditText = findViewById(R.id.usernameTextField);
        EditText emailEditText = findViewById(R.id.regEmail);
        EditText passwordEditText = findViewById(R.id.regPW);
        EditText verPasswordEditText = findViewById(R.id.verRegPW);
        Button regButton = findViewById(R.id.createAccButton);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void registerBtnPressed (){
        
    }
}
