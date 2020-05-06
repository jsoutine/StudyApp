package com.example.android.studyapp.Tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.studyapp.Calendar;
import com.example.android.studyapp.FileHelper;
import com.example.android.studyapp.MainActivity;
import com.example.android.studyapp.R;

import java.io.File;
import java.util.ArrayList;

public class ToDoList extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText itemET;
    private Button btn;
    private Button btn2;
    private ListView itemsList;

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        itemET = findViewById(R.id.item_edit_text);
        btn = findViewById(R.id.add_btn);
        btn2 = findViewById(R.id.add_calend_btn);
        itemsList = findViewById(R.id.items_list);

        items = FileHelper.readData(this);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        itemsList.setAdapter(adapter);

        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        itemsList.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_btn:
                String itemEntered = itemET.getText().toString();
                adapter.add(itemEntered);
                itemET.setText("");

                FileHelper.writeData(items, this);
                Toast.makeText(this, "Task added", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_calend_btn:
                itemEntered = itemET.getText().toString();
                adapter.add(itemEntered);
                itemET.setText("");
                FileHelper.writeData(items, this);
                Toast.makeText(this, "Task added", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, Calendar.class);
                i.putExtra("TODO_MESSAGE", itemEntered);
                startActivity (i);
                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        FileHelper.writeData(items, this);
        Toast.makeText(this, "Task deleted", Toast.LENGTH_SHORT).show();
    }
}
