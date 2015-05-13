package com.example.pc1.myapp000;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class HighScoresActivity extends ActionBarActivity {

    private ImageButton btnMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        btnMainMenu = (ImageButton) findViewById(R.id.imgbtn_main_menu);
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
