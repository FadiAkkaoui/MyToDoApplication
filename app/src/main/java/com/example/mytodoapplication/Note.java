//Referenser
//Producerad av Högskolan Väst(2020).(Spara data i en databas)[Video online] Tillgänglig: https://hv.instructure.com/courses/2994/pages/spara-data-i-appen?module_item_id=75546 [05/30 2020]


package com.example.mytodoapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Note extends Activity {

    private String date;
    private String Subject;
    private String Todo;
    private String tdate;
    public Note() {}

    public Note(String Subject, String Todo, String date, String tdate) {
        super();
        this.Subject = Subject;
        this.Todo = Todo;
        this.date = date;
        this.tdate = tdate;
    }

    //Getters & Setters
    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }

    public void setDate(String setDate) {
        this.date = setDate;
    }

    public String getDate() {
        return this.date;
    }

    public void setSubject(String setSubject) {
        this.Subject = setSubject;
    }

    public String getSubject() {
        return this.Subject;
    }

    public void setTodo(String setTodo) {

        this.Todo = setTodo;
    }

    public String getTodo() {
        return this.Todo;
    }

        @Override
    public String toString() {
        return "Subject: " + Subject + "\n" + "To do: " + Todo + "\n"+ "Deadline: " + date + "\n" + "Created: " + tdate ;
    }

}
