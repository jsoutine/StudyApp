package com.example.android.studyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterAccount extends AppCompatActivity {
    DBConnector dbConnector = new DBConnector();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void registerBtnPressed(View view) {
        EditText usernameEditText = findViewById(R.id.usernameTextField);
        EditText emailEditText = findViewById(R.id.regEmail);
        EditText passwordEditText = findViewById(R.id.regPW);
        EditText verPasswordEditText = findViewById(R.id.verRegPW);
        EditText firstNameEditText = findViewById(R.id.firstNameEditText);
        EditText lastNameEditText = findViewById(R.id.lastNameEditText);
        String email = emailEditText.getText().toString();

        if (firstNameEditText.getText().toString().isEmpty() || lastNameEditText.getText().toString().isEmpty() || usernameEditText.getText().toString().isEmpty() || emailEditText.getText().toString().isEmpty() || passwordEditText.getText().toString().isEmpty() || verPasswordEditText.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Some/all text fields are missing text. Try again!", Toast.LENGTH_SHORT).show();
        } else if (!passwordEditText.getText().toString().matches(verPasswordEditText.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Password entered doesn't match with the one entered in Verify. Try again!", Toast.LENGTH_SHORT).show();
        } else if (!emailEditText.getText().toString().isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(getApplicationContext(), "Email format not follow. Format is as follows: ---@---.---", Toast.LENGTH_SHORT).show();
        } else if (!usernameEditText.getText().toString().isEmpty() && !emailEditText.getText().toString().isEmpty() && !passwordEditText.getText().toString().isEmpty() && !verPasswordEditText.getText().toString().isEmpty() && !firstNameEditText.getText().toString().isEmpty() && !lastNameEditText.getText().toString().isEmpty() && passwordEditText.getText().toString().matches(verPasswordEditText.getText().toString()) && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            System.out.println("User creation alt. reached!");
            RegUser regUser = new RegUser(usernameEditText.getText().toString(), emailEditText.getText().toString(), passwordEditText.getText().toString(), firstNameEditText.getText().toString(), lastNameEditText.getText().toString());
            if (!dbConnector.registerBackend(regUser)){
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_SHORT).show();
            } else if (dbConnector.registerBackend(regUser)){
                Toast.makeText(getApplicationContext(), "Registration failed. Username or email already exists. Try changing these to proceed!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}