//Referenser
//activity, H., Riaz, S., Riaz, S., Humayun, D. and Riaz, S., 2020. How To Get Item Details From Listview On Another Activity. [online] Stack Overflow. Available at: <https://stackoverflow.com/questions/37860995/how-to-get-item-details-from-listview-on-another-activity> [Accessed 1 June 2020].

package com.example.mytodoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShowToDoListActivity extends AppCompatActivity {

    ArrayList<String> passedVar = new ArrayList<String>();
    private TextView passedView= null;
    private TextView passedView2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hämtar överförd data från föregående aktivitet och visar det för användaren via textviews
        setContentView(R.layout.activity_show_to_do_list);
        passedVar = getIntent().getStringArrayListExtra("item");

        passedView2 = (TextView) findViewById(R.id.TextCreate);
        passedView2.setText( "" +passedVar.get(0));

        passedView = (TextView) findViewById(R.id.Textview);
        passedView.setText("Todo: "+ passedVar.get(1) + "\n" +"Deadline: " + passedVar.get(2) + "\n" + "Created: " + passedVar.get(3));
        }


    public void btnDelete_Click(View view) {

        Intent registerIntent = new Intent(ShowToDoListActivity.this, ToDoHome.class);
        startActivity(registerIntent);
    }

}

