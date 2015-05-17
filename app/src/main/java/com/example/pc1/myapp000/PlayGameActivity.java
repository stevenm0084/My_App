package com.example.pc1.myapp000;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class PlayGameActivity extends ActionBarActivity {

    //private Weapons weapons;
    private ImageView imgViewRock;
    private ImageView imgViewPaper;
    private ImageView imgViewScissors;
    private ImageView imgViewLizzard;
    private ImageView imgViewSpock;


    private TextView txtPlayerScore, txtCpuScore;
    private ImageView playerImage;
    private ImageView cpuImage;
    private TextView resultExplaination;
    private ImageButton imgBtnNextRound;


    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        setUpVariables();
    }

    private void setUpVariables() {

        playerImage = (ImageView) findViewById(R.id.player_image);
        cpuImage = (ImageView) findViewById(R.id.cpu_image);
        resultExplaination = (TextView) findViewById(R.id.result_explaination);
        imgBtnNextRound = (ImageButton) findViewById(R.id.next_round);

        imgViewRock = (ImageView) findViewById(R.id.imgplay_rock);
        imgViewPaper = (ImageView) findViewById(R.id.imgplay_paper);
        imgViewScissors = (ImageView) findViewById(R.id.imgplay_scissors);
        imgViewLizzard = (ImageView) findViewById(R.id.imgplay_lizard);
        imgViewSpock = (ImageView) findViewById(R.id.imgplay_spock);

        txtPlayerScore = (TextView) findViewById(R.id.lbl_playerscore);
        txtCpuScore = (TextView) findViewById(R.id.lbl_compscore);

        game = new Game();

        imgViewRock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Log.i(getApplicationContext(), PlayGameActivity.class)l;
                Toast.makeText(getApplicationContext(), "You selected Rock", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("ROCK");
                game.playRound();
                updateScore();
                setContentView(R.layout.activity_end_of_round);
                isGameFinished();
            }
        });

        imgViewPaper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You selected Paper", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("PAPER");
                game.playRound();
                updateScore();
                setContentView(R.layout.activity_end_of_round);
                isGameFinished();
            }
        });

        imgViewScissors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You selected Scissors", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("SCISSORS");
                game.playRound();
                updateScore();
                setContentView(R.layout.activity_end_of_round);
                isGameFinished();
            }
        });

        imgViewLizzard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You selected rock", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("LIZARD");
                game.playRound();
                updateScore();
                setContentView(R.layout.activity_end_of_round);
                isGameFinished();
            }
        });

        imgViewSpock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You selected Spock", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("SPOCK");
                game.playRound();
                updateScore();
                setContentView(R.layout.activity_end_of_round);
                isGameFinished();
            }
        });

        imgBtnNextRound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "You selected Spock", Toast.LENGTH_SHORT).show();
                //game.setPlayerWeapon("SPOCK");
                //game.playRound();
                updateScore();
                setContentView(R.layout.activity_play_game);
                //isGameFinished();

            }
        });

    }


    public void isGameFinished(){
        if(game.isGameFinished() == true){
            Intent intent = new Intent(this, EndGameResultActivity.class);
            intent.putExtra("txtPlayerScore", game.getPlayerScore());
            intent.putExtra("txtCpuScore", game.getCpuScore());
            intent.putExtra("gameOutcome", game.getGameOutcome());
            startActivity(intent);
            finish();
        }
    }

    public void updateScore(){

        txtPlayerScore.setText(Integer.toString(game.getPlayerScore()));
        txtCpuScore.setText(Integer.toString(game.getCpuScore()));
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