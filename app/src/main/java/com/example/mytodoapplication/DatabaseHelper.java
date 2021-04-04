//Referenser
//Producerad av Högskolan Väst(2020).(Spara data i en databas)[Video online] Tillgänglig: https://hv.instructure.com/courses/2994/pages/spara-data-i-appen?module_item_id=75546 [05/30 2020]


package com.example.mytodoapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;

import javax.security.auth.Subject;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Kolumn namnen i tabellen
    public static final String SUBJECT_TABLE = "SUBJECT_TABLE";
    public static final String SUBJECT_NAME = "SUBJECT_NAME";
    public static final String TODO_LIST = "TODO_LIST";
    public static final String DATE = "DATE";
    public static final String TDATE = "TDATE";


    public DatabaseHelper(Context context) {

        super(context, SUBJECT_TABLE, null, 20);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Skapar en tabell
        String CREATE_TODO_TABLE = "CREATE TABLE " + SUBJECT_TABLE + " (" + SUBJECT_NAME  + " TEXT, " + TODO_LIST + " TEXT, " + DATE  + " TEXT, " + TDATE + " TEXT)" ;
        db.execSQL(CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS SUBJECT_TABLE");
        onCreate(db);
    }

    //Funktion som hämtar alla Notes och svaret från en lista av objekt Notes
    public List<Note> getallNotes() {

        List<Note> notes = new LinkedList<Note>();

        String query = "SELECT * FROM SUBJECT_TABLE";
        //Hämta data
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Note note = null;
        //Hämtar rad för rad
        if (cursor.moveToFirst()) {
            do {
                note = new Note();
                note.setSubject(cursor.getString(0));
                note.setTodo(cursor.getString(1));
                note.setDate(cursor.getString(2));
                note.setTdate(cursor.getString(3));
                notes.add(note);

            } while (cursor.moveToNext());

        }
        return notes;
    }
            public void addNote (Note note){
                //Hämta databasen
                SQLiteDatabase db = this.getWritableDatabase();

                //Skapa contentValues som skrivs som "column"/value
                ContentValues values = new ContentValues();

                values.put(SUBJECT_NAME, note.getSubject());
                values.put(TODO_LIST, note.getTodo());
                values.put(DATE, note.getDate());
                values.put(TDATE, note.getTdate());

                //Lägger till i tabellen
                db.insert(SUBJECT_TABLE, null, values);

                db.close();
            }
    //Raderar all data som är lagrad i databasen när metoden anropas
    public void deleteAllNotes() {
        SQLiteDatabase db = this.getWritableDatabase();
        //Raderar tabellen
        db.delete(SUBJECT_TABLE,null,null);
        db.close();
    }




}
