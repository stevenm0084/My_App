package com.example.pc1.myapp000;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//import java.nio.channels.Channel;
import android.net.wifi.p2p.WifiP2pManager.Channel;

//import java.nio.channels.Channel;


public class Play2PlayerGameActivity extends ActionBarActivity {

    //private Weapons weapons;
    private ImageView imgViewRock, imgViewPaper, imgViewScissors, imgViewLizzard, imgViewSpock;
    private TextView playerScore, cpuScore;

    private Game2Player game;

    WifiP2pManager mManager;
    WifiP2pManager.Channel mChannel;
    BroadcastReceiver mReceiver;
    IntentFilter mIntentFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), null);
        mReceiver = new RPSLSBroadcastReceiver(mManager, mChannel, this);

        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

        mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(getApplicationContext(), "Successfully discovered a peer", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int reasonCode) {
                Toast.makeText(getApplicationContext(), "failed to discovered a peer", Toast.LENGTH_SHORT).show();
            }
        });

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

        game = new Game2Player();

        imgViewRock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Log.i(getApplicationContext(), PlayGameActivity.class)l;
                Toast.makeText(getApplicationContext(), "You selected Rock", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("ROCK");
                game.playRound();
                updateScore();
                isGameFinished();
            }
        });

        imgViewPaper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You selected Paper", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("PAPER");
                game.playRound();
                updateScore();
                isGameFinished();
            }
        });

        imgViewScissors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You selected Scissors", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("SCISSORS");
                game.playRound();
                updateScore();
                isGameFinished();
            }
        });

        imgViewLizzard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You selected rock", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("LIZARD");
                game.playRound();
                updateScore();
                isGameFinished();
            }
        });

        imgViewSpock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You selected Spock", Toast.LENGTH_SHORT).show();
                game.setPlayerWeapon("SPOCK");
                game.playRound();
                updateScore();
                isGameFinished();
            }
        });
    }

    public void isGameFinished() {
        if (game.isGameFinished() == true) {
            Intent intent = new Intent(this, EndGameResultActivity.class);
            intent.putExtra("playerScore", game.getPlayerScore());
            intent.putExtra("cpuScore", game.getCpuScore());
            intent.putExtra("gameOutcome", game.getGameOutcome());
            startActivity(intent);
            finish();
        }
    }

    public void updateScore() {

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

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);
    }

    /* unregister the broadcast receiver */
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }
}