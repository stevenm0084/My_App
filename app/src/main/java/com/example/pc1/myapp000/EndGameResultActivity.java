package com.example.pc1.myapp000;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class EndGameResultActivity extends ActionBarActivity {

    private int playerScore;
    private int cpuScore;
    private Game.WinLoseOutcome gameOutcome;
    private TextView result;
    private ImageButton btnPlayAgain;
    private ImageButton btnMainMenu;
    private ImageButton btnHighScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game_result);

        result = (TextView) findViewById(R.id.txtview_result);
        btnPlayAgain = (ImageButton) findViewById(R.id.imgbtn_play_again);
        btnMainMenu = (ImageButton) findViewById(R.id.imgbtn_main_menu);
        btnHighScores = (ImageButton) findViewById(R.id.imgbtn_high_scores);

        setMainMenuButtonHandler();
        setHighScoresButtonHandler();
        setBtnPlayAgainButtonHandler();

        Intent intent = getIntent();

        int playerScore = intent.getIntExtra("playerScore", 1);
        int cpuScore = intent.getIntExtra("cpuScore", 1);
        Game.WinLoseOutcome gameOutcome = (Game.WinLoseOutcome) intent.getSerializableExtra("gameOutcome");

        checkWhoWon();

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

    public void setHighScoresButtonHandler(){
        btnHighScores.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentHighScores = new Intent(getApplicationContext(), HighScoresActivity.class);
                startActivity(intentHighScores);
                finish();
                Log.i("EndGameResult", "high scores clicked");
            }
        });
    }

    public void setBtnPlayAgainButtonHandler(){
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentPlayAgain = new Intent(getApplicationContext(), PlayGameActivity.class);
                startActivity(intentPlayAgain);
                finish();
                Log.i("EndGameResult", " play again clicked");
            }
        });
    }

    private void checkWhoWon() {
        if(gameOutcome == Game.WinLoseOutcome.WIN){

            this.result.setText("YOU WIN!");
        } else if(gameOutcome == Game.WinLoseOutcome.TIE){

            this.result.setText("GAME TIED!");
        } else{

            this.result.setText("YOU LOSE!");
        }
        updateDataBase();
    }

    private void updateDataBase() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_end_game_result, menu);
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
