package com.example.pc1.myapp000;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class PlayGameActivity extends ActionBarActivity {

    //private Weapons weapons;
    private ImageView imgViewRock, imgViewPaper, imgViewScissors, imgViewLizzard, imgViewSpock;
    private TextView playerScore, cpuScore;

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        setUpVariables();
    }

    private void setUpVariables() {
        imgViewRock = (ImageView) findViewById(R.id.imgplay_rock);
        imgViewPaper = (ImageView) findViewById(R.id.imgplay_paper);
        imgViewScissors = (ImageView) findViewById(R.id.imgplay_scissors);
        imgViewLizzard = (ImageView) findViewById(R.id.imgplay_lizard);
        imgViewSpock = (ImageView) findViewById(R.id.imgplay_spock);

        playerScore = (TextView) findViewById(R.id.lbl_playerscore);
        cpuScore = (TextView) findViewById(R.id.lbl_compscore);

        game = new Game();


        imgViewRock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Log.i(getApplicationContext(), PlayGameActivity.class)l;
                Toast.makeText(getApplicationContext(), "You selected Rock", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("ROCK");
                game.playRound();
                updateScore();
            }
        });

        imgViewPaper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You selected Paper", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("PAPER");
                game.playRound();
                updateScore();
            }
        });

        imgViewScissors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You selected Scissors", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("SCISSORS");
                game.playRound();
                updateScore();
            }
        });

        imgViewLizzard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You selected rock", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("LIZARD");
                game.playRound();
                updateScore();
            }
        });

        imgViewSpock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You selected Spock", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("SPOCK");
                game.playRound();
                updateScore();
            }
        });
    }

    public void updateScore(){

        playerScore.setText(Integer.toString(game.getPlayerScore()));
        cpuScore.setText(Integer.toString(game.getCpuScore()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play_game, menu);
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