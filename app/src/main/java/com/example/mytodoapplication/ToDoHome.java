package com.example.mytodoapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

public class ToDoHome extends AppCompatActivity {

    DatabaseHelper db = new DatabaseHelper(this);
    Button btnCreate;
    Button btnHistory;
    Button btnOption;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_home);
        readFromDatabase();

        listView =(ListView) findViewById(R.id.List_item1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Hämtar information från vald listview item och skickar med det till ShowToDoListActivity
                Note item = (Note) listView.getAdapter().getItem(position);
                ArrayList<String> info = new ArrayList<String>();

                info.add(item.getSubject());
                info.add(item.getTodo());
                info.add(item.getDate());
                info.add(item.getTdate());

                Intent launchActivity1= new Intent(ToDoHome.this,ShowToDoListActivity.class);
                launchActivity1.putExtra("item", info);
                startActivity(launchActivity1);

            }
        });

        btnCreate = findViewById(R.id.button_create);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View s) {
                Intent registerIntent = new Intent(ToDoHome.this, CreateActivity.class);
                startActivity(registerIntent);

            }
        });

        btnHistory = findViewById(R.id.button_history);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View t) {
                Intent registerIntent = new Intent(ToDoHome.this, History.class);
                startActivity(registerIntent);

            }
        });

        btnOption = findViewById(R.id.button_option);
        btnOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View t) {
                Intent registerIntent = new Intent(ToDoHome.this, OptionActivity.class);
                startActivity(registerIntent);

            }
        });

        btnOption = findViewById(R.id.button_loginH);
        btnOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View t) {
                Intent registerIntent = new Intent(ToDoHome.this, MainActivity.class);
                startActivity(registerIntent);

            }
        });
    }

    //Hämtar från databasen och placerar i listviewn
    private void readFromDatabase() {
        List<Note> list = db.getallNotes();
        String allNotes ="";
        for (Note note : list){
            allNotes += note.getSubject() + note.getDate() + System.getProperty("line.separator");
        }

        ListView Ltext = (ListView) findViewById(R.id.List_item1);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        Ltext.setAdapter(arrayAdapter);
    }

}
