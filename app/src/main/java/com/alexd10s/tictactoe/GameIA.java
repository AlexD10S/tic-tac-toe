package com.alexd10s.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.alexd10s.tictactoe.Dialogs.AlertDialogHumanWon;
import com.alexd10s.tictactoe.Dialogs.AlertDialogIADrawn;
import com.alexd10s.tictactoe.Dialogs.AlertDialogMachineWon;

import java.util.List;
import java.util.Random;

/**
 * Created by alex on 12/05/2018.
 */

public class GameIA extends AppCompatActivity {

    private ImageButton[] arrayButtons =new ImageButton[9];

    //Initialize the board for the game
    private int [] [] board = {{R.id.a1,R.id.a2,R.id.a3},{R.id.b1,R.id.b2,
            R.id.b3},{R.id.c1,R.id.c2,R.id.c3}};
    private int count;
    private int scoreA,scoreB;

    //TicTacToe
    private TicTacToe ticTacToe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initializeGame();

    }

    //Start the music when activity is running
    @Override
    protected void onResume(){
        super.onResume();
        Music.play(this, R.raw.got);
    }
    //Stop the music when activity is in background
    @Override
    protected void onPause(){
        super.onPause();
        Music.stop(this);
    }

    private void initializeGame(){
        //Initialize the counter
        count=0;
        //Initialize the scores
        scoreA=0;
        scoreB=0;
        //Catch the resources of buttons
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                arrayButtons[i] = (ImageButton) findViewById(board[i][j]);
                arrayButtons[i].setOnClickListener(listener);
            }
        }
        //Initialize the game
        ticTacToe = new TicTacToe();
    }

    public void restartBoard(){
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++){
                arrayButtons[i] = (ImageButton) findViewById(board[i][j]);
                arrayButtons[i].setImageResource(R.drawable.c4_button);
                arrayButtons[i].setOnClickListener(listener);
            }
        }
    }

    /**
     * When we click a button
     */
    private View.OnClickListener listener = new View.OnClickListener() {

        public void onClick(View view) {
            ImageButton button = (ImageButton) view;
            int id = button.getId();

            boolean validMove = false;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == id) {
                        validMove = ticTacToe.play(i, j, (count % 2) + 1);
                        break;
                    }
                }
            }

            if (validMove) {

                button.setImageResource(R.drawable.a_card);


                if (ticTacToe.isFull() || ticTacToe.Winner(1)) {
                    if (ticTacToe.Winner( 1)) {
                        new AlertDialogHumanWon().show(getFragmentManager(), "ALERT DIALOG");
                        scoreA++;
                    } else if (ticTacToe.isFull()) {
                        new AlertDialogIADrawn().show(getFragmentManager(), "ALERT DIALOG");
                    }
                } else {

                    machineMove();
                }
            }
            else {
                Toast.makeText(getApplicationContext(),"Invalid Move.", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void machineMove(){

        //stupidMove();
        //randomMove();
        pickMyMove();

    }

    private void pickMyMove(){

        int row = 0;
        int column = 0;

        //If I can win, I win
        if( !ifCanWin() ) {
            //If can lose, block the rival
            if( !ifCanLose()){
                //TODO: Try to do a Fork: Create an opportunity where you can win in two ways.
                //TODO: Try to block user Fork.
                //Play the center if can
                if(ticTacToe.getValuePosition(1,1) == 0){
                    moveThere(1,1);
                }
                //If the opponent is in the corner, play the opposite corner.
                else if(ticTacToe.getValuePosition(0,0) == 2 && ticTacToe.getValuePosition(2,2) == 0){
                    moveThere(2,2);
                }
                else if(ticTacToe.getValuePosition(2,2) == 2 && ticTacToe.getValuePosition(0,0) == 0){
                    moveThere(0,0);
                }
                else if(ticTacToe.getValuePosition(0,2) == 2 && ticTacToe.getValuePosition(2,0) == 0){
                    moveThere(2,0);
                }
                else if(ticTacToe.getValuePosition(2,0) == 2 && ticTacToe.getValuePosition(0,2) == 0){
                    moveThere(0,2);
                }
                else {
                    randomMove();
                }
                //stupidMove();
            }
        }

    }
    private boolean ifCanWin(){
        boolean done = false;
        boolean noMove = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticTacToe.nextWillWin(i,j,2) && ticTacToe.getValuePosition(i,j) == 0 && noMove) {
                    moveThere(i,j);
                    done = true;
                    noMove = false;
                    break;
                }
            }
        }

        return done;
    }

    private boolean ifCanLose(){
        boolean done = false;
        boolean noMove = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticTacToe.nextWillWin(i,j,1) && ticTacToe.getValuePosition(i,j) == 0 && noMove) {
                    moveThere(i,j);
                    done = true;
                    noMove = false;
                    break;
                }
            }
        }

        return done;
    }
    private void randomMove(){
        Random rand = new Random();
        int minBoard = 0;
        int maxBoard = 2;
        boolean noMove = true;
        while(noMove) {
            int randomNumHorizontal = rand.nextInt((maxBoard - minBoard) + 1) + minBoard;
            int randomNumVertical = rand.nextInt((maxBoard - minBoard) + 1) + minBoard;
            if (ticTacToe.getValuePosition(randomNumHorizontal,randomNumVertical) == 0) {
                noMove = false;
                moveThere(randomNumHorizontal,randomNumVertical);
            }
        }

    }
    private void stupidMove(){
        boolean noMove = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticTacToe.getValuePosition(i,j) == 0 && noMove) {
                    moveThere(i,j);
                    noMove = false;
                    break;
                }
            }
        }
    }

    private void moveThere(int i, int j){
        ticTacToe.playIA(i, j, 2);

        ImageButton button  = (ImageButton) findViewById(board[i][j]);
        button.setImageResource(R.drawable.b_card);

        if (ticTacToe.isFull() || ticTacToe.Winner(2)) {
            if (ticTacToe.Winner(2)) {
                //Toast.makeText(getApplicationContext(), R.string.gameOverB, Toast.LENGTH_LONG).show();
                new AlertDialogMachineWon().show(getFragmentManager(), "ALERT DIALOG");
                scoreB++;
            } else if (ticTacToe.isFull()) {
                new AlertDialogIADrawn().show(getFragmentManager(), "ALERT DIALOG");
            }
        }
    }

    /**
     * Menus
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Alternativa 1
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                Toast.makeText(getApplicationContext(), scoreA+"-"+scoreB, Toast.LENGTH_LONG).show();
                return true;
            case R.id.MnuOpc2:
                startActivity(new Intent("com.alexd10s.tictactoe.GAMEIA"));
                return true;
            case R.id.MnuOpc3:
                startActivity(new Intent("com.alexd10s.tictactoe.INSTRUCTIONS"));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public TicTacToe getGame(){
        return ticTacToe;
    }
}
