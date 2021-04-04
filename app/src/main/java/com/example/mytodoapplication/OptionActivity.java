//Referenser
//Producerad av techobbyist(2019).(How to toggle day night mode in android using android studio)[Video online] Tillgänglig: https://www.youtube.com/watch?v=pEWze95xddM&fbclid=IwAR0yBXDj-oYD5A3lj3O7D6MF-Ue4ChiQZxcv0riNvZsjCHDON6J1RlKyk44 [06/01 2020]

package com.example.mytodoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class OptionActivity extends AppCompatActivity {

    private Switch aSwitch;
    public static final String MyPREFERENCES = "nightModePrefs";
    public static final String KEY_ISNIGHTMODE = "isNightMode";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_mode);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);

        aSwitch = findViewById(R.id.switch_mode);
        //Anropar metoden
        checkNightModeActivated();

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    saveNightModeState(true);
                    recreate();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    saveNightModeState(false);
                    recreate();
                }
            }
        });
    }

    private void saveNightModeState(boolean nightMode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(KEY_ISNIGHTMODE, nightMode);

        editor.apply();
    }

    public void checkNightModeActivated(){

        if (sharedPreferences.getBoolean(KEY_ISNIGHTMODE,false)) {
            aSwitch.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else {
            aSwitch.setChecked(false);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    public void btnCreate_Click2(View view) {

        Intent registerIntent = new Intent(OptionActivity.this, ToDoHome.class);
        startActivity(registerIntent);
    }


}
