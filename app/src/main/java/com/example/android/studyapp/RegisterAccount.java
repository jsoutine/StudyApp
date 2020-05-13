package com.example.android.studyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.IllegalFormatException;

public class RegisterAccount extends AppCompatActivity {
    DBConnector dbConnector = new DBConnector();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void registerBtnPressed(View view) {
        EditText firstNameEditText = findViewById(R.id.firstNameEditText);
        EditText lastNameEditText = findViewById(R.id.lastNameEditText);
        EditText usernameEditText = findViewById(R.id.usernameTextField);
        EditText emailEditText = findViewById(R.id.regEmail);
        EditText passwordEditText = findViewById(R.id.regPW);
        EditText verPasswordEditText = findViewById(R.id.verRegPW);

        if (firstNameEditText.getText().toString().isEmpty() || lastNameEditText.getText().toString().isEmpty() || usernameEditText.getText().toString().isEmpty() || emailEditText.getText().toString().isEmpty() || passwordEditText.getText().toString().isEmpty() || verPasswordEditText.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Some/all text fields are missing text. Try again!", Toast.LENGTH_SHORT).show();
        } else if (!passwordEditText.getText().toString().matches(verPasswordEditText.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Password entered doesn't match with the one entered in Verify. Try again!", Toast.LENGTH_SHORT).show();
        } else {//if (dbConnector.registerBackend(firstNameEditText.getText().toString(), lastNameEditText.getText().toString(), usernameEditText.getText().toString(), emailEditText.getText().toString(), passwordEditText.getText().toString()) && passwordEditText.getText().toString().matches(verPasswordEditText.getText().toString())) {
            Toast.makeText(getApplicationContext(), "REGISTERED (TEST MESSAGE)", Toast.LENGTH_SHORT).show();
        }
    }
}