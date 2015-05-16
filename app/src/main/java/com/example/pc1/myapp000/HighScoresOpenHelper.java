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

    private static final String DATABASE_NAME = "Highscores";
    private static final String TABLE_HIGHSCORES = "Highscores";
    private static final int DATABASE_VERSION = 1;


    public HighScoresOpenHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        Log.i("HighScoresOpenHelper: ", "DATABASE COMPLETE BUILD");
        setup(database);//ddd
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        setup(database);
    }

    public void setup(SQLiteDatabase database){
        database.execSQL("DROP TABLE IF EXISTS HighScores;");
        database.execSQL("CREATE TABLE " + TABLE_HIGHSCORES + " (name TEXT, score TEXT, datetime TEXT);");

        Time now = new Time();
        now.setToNow();
        Log.i("HighScoresOpenHelper: ", "DATABASE INSERTED 1 ITEM");
        String insertString = "INSERT INTO " + DATABASE_NAME + " (name, score, datetime)" + " VALUES ('Bob', '3', '3:30pm');";
        database.execSQL(insertString);

        Log.i("HighScoresOpenHelper: ", "DATABASE INSERTED 2nd ITEM");
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
