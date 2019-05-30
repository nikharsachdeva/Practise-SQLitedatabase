package com.example.android.sqlitedatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDatabaseandTable();
        insertQuery();
        fetchQuery();
    }

    public void createDatabaseandTable(){

        myDatabase = this.openOrCreateDatabase("Notes",MODE_PRIVATE,null);

        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS notes(id INTEGER PRIMARY KEY,text VARCHAR)");
    }

    public void insertQuery(){

       myDatabase.execSQL("INSERT INTO notes(text) VALUES('First Note') ");
        //myDatabase.execSQL("DELETE FROM notes");
        //Toast.makeText(this,"Successful",Toast.LENGTH_SHORT);
        //myDatabase.execSQL("INSERT INTO notes VALUES ('"+editText.getText().toString()+"')");
    }

    public void fetchQuery(){
        Cursor c = myDatabase.rawQuery("SELECT * FROM notes",null);

        int textIndex = c.getColumnIndex("text");
//        c.moveToFirst();

        if (c != null)
            if (c.moveToFirst()) {
                do {
                    Log.i("entry000",c.getString(textIndex));
                } while (c.moveToNext());
            }

    }

    }
