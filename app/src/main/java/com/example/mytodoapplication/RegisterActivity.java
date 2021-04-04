//Referenser
//Producerad av EazyLearn(2018).(Create Login And Registration Screen In Android Using SQLite | App Development Tutorial- Part 1)[Video online] Tillgänglig: https://www.youtube.com/watch?v=mPhqDzO7PUU [06/01 2020]
//Producerad av Högskolan Väst(2020).(Toast och flera sidor)[Video online] Tillgänglig: https://hv.instructure.com/courses/2994/pages/toast-och-flera-sidor?module_item_id=75058 [06/01 2020]
package com.example.mytodoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    EditText TextUsername;
    EditText TextPassword;
    EditText TextConfirmPw;
    Button BtnRegister;
    TextView TextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextUsername = (EditText)findViewById(R.id.edittext_username);
        TextPassword = (EditText)findViewById(R.id.edittext_password);
        TextConfirmPw = (EditText)findViewById(R.id.edittext_to_password);

        TextViewLogin = (TextView) findViewById(R.id.textview_login);
        TextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(LoginIntent);
            }
        });
            BtnRegister = (Button) findViewById(R.id.button_register);
            BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View W) {
                Intent RegisterIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(RegisterIntent);
            }
        });


    }
}
