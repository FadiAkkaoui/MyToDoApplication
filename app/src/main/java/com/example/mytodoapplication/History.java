package com.example.mytodoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.List;

public class History extends AppCompatActivity {
    DatabaseHelper db = new DatabaseHelper(this);
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        readFromDatabase();
    }

    private void readFromDatabase() {
        //Hämtar alla notes från databasen
        List<Note> list = db.getallNotes();
        String allNotes = "";
        for (Note note : list) {

            allNotes += note.getSubject() + System.getProperty("line.separator");
        }

        ListView Ltext = (ListView) findViewById(R.id.List_item1);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        Ltext.setAdapter(arrayAdapter);
    }


    public void btnDelete_Click(View view) {
        //Anropar Metoden deleteAllNotes
        db.deleteAllNotes();
        readFromDatabase();
    }

    public void btnHome_click(View view) {

        Intent registerIntent = new Intent(History.this, ToDoHome.class);
        startActivity(registerIntent);
    }

}


