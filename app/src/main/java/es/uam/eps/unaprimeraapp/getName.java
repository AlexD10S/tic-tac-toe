package es.uam.eps.unaprimeraapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;



public class getName extends Activity {
    private EditText campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_name);
        campo=(EditText) findViewById(R.id.entry);
    }

    /**
     * Al pulsar el boton de paly, se invoca este metodo y comenzamos la actividad
     */
    public void onButtonPlayClick(View v){
        //Intent i=new Intent("es.uam.eps.unaprimeraapp.MAINACTIVITY");
        //i.putExtra("nombre",campo.getText()+"");
        //startActivity(i);
        startActivity(new Intent("es.uam.eps.unaprimeraapp.MENUACTIVITY"));

    }

}
