package com.example.android.studyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity{
    DBConnector dbConnector = new DBConnector();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void mainActivityBtnPressed (View view) {
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);

        if (usernameEditText.getText().toString().isEmpty() && passwordEditText.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Username and password fields are empty." , Toast.LENGTH_SHORT).show();
        } else if (usernameEditText.getText().toString().isEmpty() || passwordEditText.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Username or password fields are empty." , Toast.LENGTH_SHORT).show();
        } else {
            dbConnector.loginBackend(usernameEditText.getText().toString(), passwordEditText.getText().toString());

            if(DBConnector.loggedInUser.getUsername().matches(usernameEditText.getText().toString()) && DBConnector.loggedInUser.getPassword().matches(passwordEditText.getText().toString())){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity (intent);
            } else {
                Toast.makeText(getApplicationContext(), "Error with login" , Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void registerBtnPressed (View view){
        Intent intent = new Intent(this, RegisterAccount.class);
        startActivity(intent);
    }
}