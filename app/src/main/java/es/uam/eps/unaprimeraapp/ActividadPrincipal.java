package es.uam.eps.unaprimeraapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;

public class ActividadPrincipal extends Activity {

    //Initializa Buttons

    private ImageButton[] arrayButtons =new ImageButton[9];

    private int [] [] board = {{R.id.a1,R.id.a2,R.id.a3},{R.id.b1,R.id.b2,
            R.id.b3},{R.id.c1,R.id.c2,R.id.c3}};
    //nOMBRE
    private TextView nombrePlayer;
    //Counter for turn
    private int contador;
    //Puntos de A y Puntos de B
    private int scoreA,scoreB;
    //Game
    private Game g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);
        //Recibimos el nombre del rival
        String nombre = getIntent().getStringExtra("nombre");
       // nombrePlayer=(TextView) findViewById(R.id.entry);
        //Cambiar el nombre
        //nombrePlayer.setText("a");
        //Initialize the counter
        contador=0;
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
        //Inicializo el juego
        g=new Game();


        
    }
    //Para comenzar a reproducir musica cuando la actividad este en 1º plano
    protected void onResume(){
        super.onResume();
        Music.play(this, R.raw.got);
    }
    //Para que la musica se detenga cuando la actividad pase a un segundo plano
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
     * Metodo para cuando pulsamos un boton
     */
    private OnClickListener listener = new OnClickListener() {
        public void onClick(View view) {

            ImageButton button = (ImageButton) view;
            //id del boton
            int id= button.getId();
            for (int i=0; i<3; i++)
                for (int j=0; j<3; j++)
                    if (board[i][j] == id) {
                        g.play(i, j,(contador %2) + 1);
                        break;
                    }

            //Si es el jugador 1
            if (contador % 2 == 0) {
                button.setImageResource(R.drawable.a_card);
            }
            //Si es el jugador 2
            else {
                button.setImageResource(R.drawable.b_card);
            }

            if(g.isFull() || g.Winner((contador % 2) +1)){
                if(g.Winner((contador % 2) +1)){
                    if((contador % 2)==0) {
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
                    new AlertDialogEmpate().show(getFragmentManager(), "ALERT DIALOG");
                }
                //g.restart();
                //restartBoard();
                contador=0;


            }
            else contador++;
        }
    };

    /**
     * Menus
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Alternativa 1
        getMenuInflater().inflate(R.menu.menu_menu_principal, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                Toast.makeText(getApplicationContext(), scoreA+"-"+scoreB, Toast.LENGTH_LONG).show();
                return true;
            case R.id.MnuOpc2:
                startActivity(new Intent("es.uam.eps.unaprimeraapp.INSTRUCCIONES"));
                return true;
            case R.id.MnuOpc3:
                Toast.makeText(getApplicationContext(),"Alex 100% Victorias", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public Game getGame(){
        return g;
    }



}
