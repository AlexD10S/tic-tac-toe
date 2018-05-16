package com.alexd10s.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    private Button buttonPlay,buttonInfo,buttonMachine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setupButtons();
    }

    private void setupButtons(){
        buttonPlay = (Button) findViewById(R.id.ButtonPlay);
        buttonInfo = (Button) findViewById(R.id.ButtonInfo);
        buttonMachine = (Button) findViewById(R.id.ButtonRecord);
    }

    /**
     * When user push the button play vs another player
     */
    public void onButtonPlayClick(View v){
        startActivity(new Intent("com.alexd10s.tictactoe.GAME"));

    }
    /**
     * When user push the button play vs machine
     */
    public void onButtonMachineClick(View v) {
        Intent i = new Intent(getBaseContext(), GameIA.class);
        startActivity(i);
    }
    /**
     * When user push the button How to play
     */
    public void onButtonInstClick(View v){
        startActivity(new Intent("com.alexd10s.tictactoe.INSTRUCTIONS"));
    }

}
