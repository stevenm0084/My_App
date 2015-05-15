package com.example.pc1.myapp000;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.text.format.Time;
import android.util.Log;


/**
 * Created by PC1 on 14-May-15.
 */
public class HighScoresOpenHelper extends SQLiteOpenHelper{

    public HighScoresOpenHelper(Context context){

        super(context, "HighScores", null, 1);
        System.out.println("HighScoresOpenHelper: insert 2nd");
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        Log.d("HighScoresOpenHelper: ", "DATABASE COMPLETE BUILD");
        setup(database);//ddd
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        setup(database);
    }

    public void setup(SQLiteDatabase database){
        database.execSQL("DROP TABLE IF EXISTS HighScores;");
        database.execSQL("CREATE TABLE HighScores" + " (name TEXT, score TEXT, datetime TEXT);");

        Time now = new Time();
        now.setToNow();
        System.out.println("HighScoresOpenHelper: insert 1st");
        String insertString = "INSERT INTO HighScores" + " (name, score, datetime)" + " VALUES ('Bob', '3', '3:30pm');";
        database.execSQL(insertString);

        System.out.println("HighScoresOpenHelper: insert 2nd");
        insertString = "INSERT INTO HighScores" + " (name, score, datetime)" + " VALUES ('Sam', '2', '3:30pm');";
        database.execSQL(insertString);

        insertString = "INSERT INTO HighScores" + " (name, score, datetime)" + " VALUES ('dave', '1', '3:30pm');";
        database.execSQL(insertString);

        insertString = "INSERT INTO HighScores" + " (name, score, datetime)" + " VALUES ('jenny', '0', '3:30pm');";
        database.execSQL(insertString);

        /*insertString = String.format("INSERT INTO HighScores" + " (name,score,datetime)" + " VALUES (\"Allen\",\"5\"%s\");",now);
        database.execSQL(insertString);*/
    }
}
