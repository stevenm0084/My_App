package com.example.pc1.myapp000;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.ViewGroup;


public class EndGameResultActivity extends ActionBarActivity {

    private Game.WinLoseOutcome gameOutcome;
    private TextView result;
    private ImageButton btnPlayAgain;
    private ImageButton btnMainMenu;
    private ImageButton btnsubmit;
    private ImageButton btnHighScores;
    private ImageButton btnPlayAgan;

    private EditText editTxtPlayerName;

    private ViewGroup layoutWonGame;

    private int playerScore;
    private int cpuScore;
    private String playerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_end_game_lost);
        setContentView(R.layout.activity_end_game_won);

        result = (TextView) findViewById(R.id.txtview_result);
        btnsubmit = (ImageButton) findViewById(R.id.btn_submit);
        btnPlayAgan = (ImageButton) findViewById(R.id.imgbtn_playagain);
        btnHighScores = (ImageButton) findViewById(R.id.imgbtn_highscores);

        editTxtPlayerName = (EditText) findViewById(R.id.playername);

        setSubmitButtonHandler();
        setHighScoresButtonHandler();
        //setPlayAgainButtonHandler();

        Intent intent = getIntent();

        playerScore = intent.getIntExtra("playerScore", 1);
        cpuScore = intent.getIntExtra("cpuScore", 1);
        Game.WinLoseOutcome gameOutcome = (Game.WinLoseOutcome) intent.getSerializableExtra("gameOutcome");

        checkWhoWon();

    }

    public void wonGame(){

    }

    public void setSubmitButtonHandler() {
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerName = editTxtPlayerName.getText().toString();
                Log.i("EndGameResult", "high scores clicked. Name = " + playerName + " Score = " + playerScore);

                Intent intentHighScores = new Intent(getApplicationContext(), HighScoresActivity.class);
                intentHighScores.putExtra("playerName", playerName);
                intentHighScores.putExtra("playerScore", playerScore);

                startActivity(intentHighScores);
                finish();
            }
        });
    }

    /*public void setPlayAgainButtonHandler(){
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentPlayAgain = new Intent(getApplicationContext(), PlayGameActivity.class);
                startActivity(intentPlayAgain);
                finish();
                Log.i("EndGameResult", " play again clicked");
            }
        });
    }*/

    public void setHighScoresButtonHandler(){
        btnHighScores.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerName = editTxtPlayerName.getText().toString();
                Intent intentHighScores = new Intent(getApplicationContext(), HighScoresActivity.class);
                intentHighScores.putExtra("playerName", playerName);
                intentHighScores.putExtra("playerScore", playerScore);
                Log.i("EndGameResult", "high scores clicked");
                startActivity(intentHighScores);
                finish();
            }
        });
    }


    private void checkWhoWon() {
        if(gameOutcome == Game.WinLoseOutcome.WIN){
            this.result.setText("YOU WIN!");

        } else if (gameOutcome == Game.WinLoseOutcome.TIE) {
            this.result.setText("GAME TIED!");

        } else {
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
