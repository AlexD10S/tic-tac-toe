package com.alexd10s.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    //Buttons
    private Button buttonPlay,buttonInfo,buttonRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        buttonPlay = (Button) findViewById(R.id.ButtonPlay);
        buttonInfo = (Button) findViewById(R.id.ButtonInfo);
        buttonRecord = (Button) findViewById(R.id.ButtonRecord);
    }

    /**
     * When user push the button play
     */
    public void onButtonPlayClick(View v){
        startActivity(new Intent("com.alexd10s.tictactoe.GAME"));

    }
    /**
     * When user push the button How to play
     */
    public void onButtonInstClick(View v){
        startActivity(new Intent("com.alexd10s.tictactoe.INSTRUCTIONS"));
    }
    /**
     * When user push the button Records
     * Pd: Implement in the future new functionalities with database
     */
    public void onButtonRecordClick(View v) {
        Toast.makeText(getApplicationContext(), "Alex 100% Victories", Toast.LENGTH_LONG).show();
    }
}
