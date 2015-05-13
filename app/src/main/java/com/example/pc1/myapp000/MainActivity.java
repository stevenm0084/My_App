package com.example.pc1.myapp000;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;
/*
 - Button images created courtesy of http://dabuttonfactory.com/
 - Game images used courtesy of
 - Title texts created courtesy of http://cooltext.com*/

public class MainActivity extends ActionBarActivity {
    ImageButton imgBtnSnglPlayGame, imgBtnTwoPlayGame, imgBtnHighScores, imgBtnAbout;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addOnSnglPlayGameHandler();
        addOnTwoPlayGameHandler();
        addOnViewHighscoresHandler();
        addOnViewAboutAppHandler();

        title = (TextView) findViewById(R.id.title_mainmenu);
        Typeface titleFont = Typeface.createFromAsset(getAssets(), "fonts/CFPunkisnotDead-Regular.ttf");
        title.setTypeface(titleFont);

    }

    private void addOnSnglPlayGameHandler() {
        imgBtnSnglPlayGame = (ImageButton) findViewById(R.id.imgbtn_snglplaygame);
        imgBtnSnglPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(MainActivity.class.getName(), "SinglePlayer Activity called");
                Intent intentPlayGame = new Intent(getApplicationContext(), PlayGameActivity.class);
                startActivity(intentPlayGame);
            }
        });
    }

    private void addOnTwoPlayGameHandler() {
        imgBtnTwoPlayGame = (ImageButton) findViewById(R.id.imgbtn_twoplaygame);
        imgBtnTwoPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(MainActivity.class.getName(), "TwoPlayer game Activity called");

                Intent intentTwoPlayGame = new Intent();
                startActivity(intentTwoPlayGame);

            }
        });
    }

    private void addOnViewHighscoresHandler() {
        imgBtnHighScores = (ImageButton) findViewById(R.id.imgbtn_highscores);
        imgBtnHighScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(MainActivity.class.getName(), "HighScores Activity called");
                Intent intentHighScoresGame = new Intent();
                startActivity(intentHighScoresGame);

            }
        });
    }

    private void addOnViewAboutAppHandler() {
        imgBtnAbout = (ImageButton) findViewById(R.id.imgbtn_about);
        imgBtnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(MainActivity.class.getName(), "About Activity called");
                Intent intentAboutApp = new Intent();
                startActivity(intentAboutApp);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent intent = new Intent(this, Settings.class);
            startActivityForResult(intent, 1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1 && resultCode == RESULT_OK) {
            boolean sound = data.getBooleanExtra("sound", true);
            boolean shakeToPlay = data.getBooleanExtra("shakeToPlay", true);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}