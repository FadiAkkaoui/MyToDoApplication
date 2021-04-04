//Referenser
//Producerad av EazyLearn(2018).(Create Login And Registration Screen In Android Using SQLite | App Development Tutorial- Part 1)[Video online] Tillgänglig: https://www.youtube.com/watch?v=mPhqDzO7PUU [06/01 2020]
//Producerad av Högskolan Väst(2020).(Toast och flera sidor)[Video online] Tillgänglig: https://hv.instructure.com/courses/2994/pages/toast-och-flera-sidor?module_item_id=75058 [06/01 2020]

package com.example.mytodoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<val> extends AppCompatActivity {

    EditText TextUsername;
    EditText TextPassword;
    Button BtnLogin;
    TextView TextViewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextUsername = (EditText)findViewById(R.id.edittext_username);
        TextPassword = (EditText)findViewById(R.id.edittext_password);
        BtnLogin = (Button) findViewById(R.id.button_login);
        TextViewRegister = (TextView) findViewById(R.id.textview_register);

        TextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        BtnLogin = (Button) findViewById(R.id.button_login);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextUsername = (EditText)findViewById(R.id.edittext_username);
                TextPassword = (EditText)findViewById(R.id.edittext_password);
                String inputName = TextUsername.getText().toString();
                String inputPassword = TextPassword.getText().toString();
                //Förbestämd log in
                if (inputName.equals("Fadi") && inputPassword.equals("Hv")){
                    Intent loginIntent = new Intent(MainActivity.this, ToDoHome.class);
                    startActivity(loginIntent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Not registered, try again!" , Toast.LENGTH_SHORT).show();
                }
            }

        });


    }
}
