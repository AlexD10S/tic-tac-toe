package es.uam.eps.unaprimeraapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class MenuPrincipal extends Activity {

    //Botones
    private Button buttonPlay,buttonInfo,buttonRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        buttonPlay = (Button) findViewById(R.id.ButtonPlay);
        buttonInfo = (Button) findViewById(R.id.ButtonInfo);
        buttonRecord = (Button) findViewById(R.id.ButtonRecord);
    }

    /**
     * Al pulsar el boton de paly, se invoca este metodo y comenzamos la actividad
     */
    public void onButtonPlayClick(View v){
        //startActivity(new Intent("es.uam.eps.unaprimeraapp.NAME"));
        startActivity(new Intent("es.uam.eps.unaprimeraapp.MAINACTIVITY"));

    }
    /**
     * Al pulsar el boton de Instrucciones,se invoca este metodo
     */
    public void onButtonInstClick(View v){
        startActivity(new Intent("es.uam.eps.unaprimeraapp.INSTRUCCIONES"));
    }
    public void onButtonRecordClick(View v) {
        Toast.makeText(getApplicationContext(), "Alex 100% Victorias", Toast.LENGTH_LONG).show();
    }


}
