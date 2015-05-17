package com.example.pc1.myapp000;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MultiplayerMenuActivity extends ActionBarActivity {

    private ImageButton btnCreateGame;
    private ImageButton btnJoinGame;
    private ImageButton btnMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_menu);


    }

    public void setCreateGameButtonHandler() {
        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentTwoPlayGame = new Intent(getApplicationContext(), Play2PlayerGameActivity.class);
                startActivity(intentTwoPlayGame);
                Log.i("EndGameResult", "create game clicked");
                finish();
            }
        });
    }

    public void setJoinGameButtonHandler() {
        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentJoinGameLobby = new Intent(getApplicationContext(), GameLobbyActivity.class);
                startActivity(intentJoinGameLobby);
                Log.i("EndGameResult", "join game clicked");
                finish();
            }
        });
    }

    public void setMainMenuButtonHandler() {
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
        getMenuInflater().inflate(R.menu.menu_game_lobby, menu);
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
