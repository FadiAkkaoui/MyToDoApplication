//Referenser
//Reddy, P., 2020. Calendar Class In Java With Examples - Geeksforgeeks. [online] GeeksforGeeks. Available at: <https://www.geeksforgeeks.org/calendar-class-in-java-with-examples/> [Accessed 31 May 2020].

package com.example.mytodoapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class CreateActivity extends AppCompatActivity {

    DatabaseHelper db = new DatabaseHelper(this);
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        calendar = Calendar.getInstance();
    }

    public void btnAdd_Click(View view) {

        EditText textsubject = (EditText) findViewById(R.id.insertsubject);
        EditText texttodo = (EditText) findViewById(R.id.inserttodo);
        EditText textdate = (EditText) findViewById(R.id.insertdate);
        //Hämtar inmatad data
        String sub = textsubject.getText().toString();
        String todo = texttodo.getText().toString();
        String date = textdate.getText().toString();

        Note n = new Note();
        //Tillsätter inmatad data
        n.setSubject(sub);
        n.setTodo(todo);
        n.setDate(date);
        //Hämtar aktuell datum och tid
        String created = calendar.getTime().toString();

        n.setTdate((created));
        //Lagrar i databasen
        db.addNote(n);

        Intent registerIntent = new Intent(CreateActivity.this, ToDoHome.class);
        startActivity(registerIntent);

        Toast.makeText(getApplicationContext(), "Item created!" , Toast.LENGTH_SHORT).show();
    }

        //Tillsätter värdet 0 vid start på datum under 10 exempelvis 7 blir 07
        private String addZero(int i){
          if(i<10)
              return "0"+i;
              return String.valueOf(i);
            }


}