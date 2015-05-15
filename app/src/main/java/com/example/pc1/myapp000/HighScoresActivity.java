package com.example.pc1.myapp000;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;


public class HighScoresActivity extends ActionBarActivity {

    private ImageButton btnMainMenu;
    private HighScoresOpenHelper highScoresOpenHelper;
    private ArrayAdapter<String> highscores;
    private ListView listViewHighscores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);
        //setup array adapter
        highscores = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        listViewHighscores = (ListView) findViewById(R.id.listView_highscores);
        listViewHighscores.setAdapter(highscores);

        btnMainMenu = (ImageButton) findViewById(R.id.imgbtn_main_menu);

        highScoresOpenHelper = new HighScoresOpenHelper(this);

        SQLiteDatabase db = highScoresOpenHelper.getReadableDatabase();

        Cursor cursor = db.query(true, "Highscores", null, null, null, null, null, null, null);

        int count = cursor.getCount();
        Log.i("HighScoresActivity", "DB Cursor count = " + count);

        while (cursor.moveToNext()){
            String name = cursor.getString(0);
            String score = cursor.getString(1);
            String when = cursor.getString(2);

            highscores.add(name + "     " + score + "     " + when);
            Log.i("HighScoresActivity", "while running...");
        }
        cursor.close();

        setMainMenuButtonHandler();
    }

    public void setMainMenuButtonHandler(){
        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentMainMenu = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentMainMenu);
                Log.i("EndGameResult", "main menu clicked");
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_high_scores, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
