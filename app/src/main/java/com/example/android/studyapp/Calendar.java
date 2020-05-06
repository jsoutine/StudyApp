package com.example.android.studyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Calendar extends AppCompatActivity {

    private int currentYear = 0;
    private int currentMonth = 0;
    private int currentDay = 0;

    private int index = 0;

    private List<String> calendarStrings;
    private int[] days;
    private int[] months;
    private int[] years;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        final CalendarView calendarView = findViewById(R.id.calendarView);
        calendarStrings = new ArrayList<>();
        final int numberOfDays = 2000;
        days = new int[numberOfDays];
        months = new int[numberOfDays];
        years = new int[numberOfDays];

        readInfo();

        final EditText textInput = findViewById(R.id.textInputCalend);
        Button getTodoMess = (Button) findViewById(R.id.todoMessBtn);
        getTodoMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTodoClick(view);
            }
        });

        Button getEventMess = (Button) findViewById(R.id.eventMessBtn);
        getEventMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEventClick(view);
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                currentYear = year;
                currentMonth = month;
                currentDay = dayOfMonth;

                for (int h = 0; h < index; h++) {
                    if (years[h] == currentYear) {
                        for (int i = 0; i < index; i++) {
                            if (days[i] == currentDay) {
                                for (int j = 0; j < index; j++) {
                                    if (months[j] == currentMonth && days[j] == currentDay && years[j] == currentYear) {
                                        textInput.setText(calendarStrings.get(j));
                                        return;
                                    }
                                }

                            }
                        }
                    }
                }
                textInput.setText("");
            }
        });

        final Button saveTextButton = findViewById(R.id.saveTextButton);
        saveTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                days[index] = currentDay;
                months[index] = currentMonth;
                years[index] = currentYear;
                calendarStrings.add(index, textInput.getText().toString());
                saveInfo();
                textInput.setText("");
                index++;


            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveInfo();
    }

    private void saveInfo() {
        File file = new File(this.getFilesDir(), "saved");
        File daysFile = new File(this.getFilesDir(), "days");
        File monthsFile = new File(this.getFilesDir(), "months");
        File yearsFile = new File(this.getFilesDir(), "years");

        try {
            FileOutputStream fOut = new FileOutputStream(file);
            BufferedWriter bW = new BufferedWriter(new OutputStreamWriter(fOut));

            FileOutputStream fOutDays = new FileOutputStream(daysFile);
            BufferedWriter bwDays = new BufferedWriter(new OutputStreamWriter(fOutDays));

            FileOutputStream fOutMonths = new FileOutputStream(monthsFile);
            BufferedWriter bwMonths = new BufferedWriter(new OutputStreamWriter(fOutMonths));

            FileOutputStream fOutYears = new FileOutputStream(yearsFile);
            BufferedWriter bwYears = new BufferedWriter(new OutputStreamWriter(fOutYears));

            for (int i = 0; i < index; i++) {
                bW.write(calendarStrings.get(i));
                bW.newLine();
                bwDays.write(days[i]);
                bwMonths.write(months[i]);
                bwYears.write(years[i]);


            }

            bW.close();
            fOut.close();
            bwDays.close();
            fOutDays.close();
            bwMonths.close();
            fOutMonths.close();
            bwYears.close();
            fOutYears.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readInfo() {
        File file = new File(this.getFilesDir(), "saved");
        File daysFile = new File(this.getFilesDir(), "days");
        File monthsFile = new File(this.getFilesDir(), "months");
        File yearsFile = new File(this.getFilesDir(), "years");

        if (!file.exists()) {
            return;
        }
        try {
            FileInputStream is = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            FileInputStream isDays = new FileInputStream(daysFile);
            BufferedReader readerDays = new BufferedReader(new InputStreamReader(isDays));
            FileInputStream isMonths = new FileInputStream(monthsFile);
            BufferedReader readerMonths = new BufferedReader(new InputStreamReader(isMonths));
            FileInputStream isYears = new FileInputStream(yearsFile);
            BufferedReader readerYears = new BufferedReader(new InputStreamReader(isYears));

            int i = 0;
            String line = reader.readLine();
            while (line != null) {
                calendarStrings.add(line);
                days[i] = readerDays.read();
                months[i] = readerMonths.read();
                years[i] = readerYears.read();
                i++;
                line = reader.readLine();
            }

            index = i;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getTodoClick(View view) {
        EditText textInput = findViewById(R.id.textInputCalend);
        Intent intent = getIntent();
        String todoMessage = intent.getStringExtra("TODO_MESSAGE");
        textInput.setText(todoMessage);
    }

    public void getEventClick(View view) {
        EditText textInput = findViewById(R.id.textInputCalend);
        Intent intent = getIntent();
        String eventMessage = intent.getStringExtra("EVENT_MESSAGE");
        textInput.setText(eventMessage);
    }

    public void backClick(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}