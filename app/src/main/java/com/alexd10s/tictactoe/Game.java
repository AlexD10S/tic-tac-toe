package com.alexd10s.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    private ImageButton[] arrayButtons =new ImageButton[9];

    //Initialize the board for the game
    private int [] [] board = {{R.id.a1,R.id.a2,R.id.a3},{R.id.b1,R.id.b2,
            R.id.b3},{R.id.c1,R.id.c2,R.id.c3}};
    //Name player
    private TextView nombrePlayer;
    //Counter for turn
    private int count;
    //Score for A and Score for B
    private int scoreA,scoreB;
    //TicTacToe
    private TicTacToe g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //get the name
        String nombre = getIntent().getStringExtra("nombre");

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
        g=new TicTacToe();
    }
    //Start the music when activity is running
    protected void onResume(){
        super.onResume();
        Music.play(this, R.raw.got);
    }
    //Stop the music when activity is in background
    protected void onPause(){
        super.onPause();
        Music.stop(this);
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
    private OnClickListener listener = new OnClickListener() {
        public void onClick(View view) {

            ImageButton button = (ImageButton) view;
            //id del boton
            int id= button.getId();
            for (int i=0; i<3; i++)
                for (int j=0; j<3; j++)
                    if (board[i][j] == id) {
                        g.play(i, j,(count %2) + 1);
                        break;
                    }

            //Player1
            if (count % 2 == 0) {
                button.setImageResource(R.drawable.a_card);
            }
            //if is Player2
            else {
                button.setImageResource(R.drawable.b_card);
            }

            if(g.isFull() || g.Winner((count % 2) +1)){
                if(g.Winner((count % 2) +1)){
                    if((count % 2)==0) {
                        //Toast.makeText(getApplicationContext(), R.string.gameOverA, Toast.LENGTH_LONG).show();
                        new AlertDialogA().show(getFragmentManager(), "ALERT DIALOG");
                        scoreA++;
                    }
                    else {
                        //Toast.makeText(getApplicationContext(), R.string.gameOverB, Toast.LENGTH_LONG).show();
                        new AlertDialogB().show(getFragmentManager(), "ALERT DIALOG");
                        scoreB++;
                    }
                }
                else if(g.isFull()){
                    new AlertDialogDrawn().show(getFragmentManager(), "ALERT DIALOG");
                }
                //g.restart();
                //restartBoard();
                count=0;


            }
            else count++;
        }
    };

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
                startActivity(new Intent("com.alexd10s.tictactoe.INSTRUCTIONS"));
                return true;
            case R.id.MnuOpc3:
                Toast.makeText(getApplicationContext(),"Alex 100% Victories", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public TicTacToe getGame(){
        return g;
    }
}
