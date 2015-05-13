package com.example.pc1.myapp000;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.text.format.Time;


/**
 * Created by PC1 on 14-May-15.
 */
public class HighScoresOpenHelper extends SQLiteOpenHelper{

    public HighScoresOpenHelper(Context context){
        super(context, "HighScores", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        setup(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        setup(database);
    }

    public void setup(SQLiteDatabase database){
        database.execSQL("DROP TABLE IF EXISTS HighScores;");
        database.execSQL("CREATE TABLE HighScores" + "name TEXT, score TEXT, datetime TEXT");

        Time now = new Time();
        now.setToNow();
        String insertString = String.format("INSERT INTO HighScores" + "(name,score,datetime)" + " VALUES (\"Bob\",\"3\"%s\");",now);

        database.exeSQL(insertString);
    }

}
