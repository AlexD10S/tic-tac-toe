package es.uam.eps.unaprimeraapp;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.content.DialogInterface;
/**
 * Muetra un dialogo al terminar la partida
 */
public class AlertDialogEmpate extends DialogFragment{
    @Override
    public Dialog onCreateDialog (Bundle savedInstancedState){
        final ActividadPrincipal main = (ActividadPrincipal) getActivity();
        //Creamos el AlertDialog y le asignamos titulo y mensaje
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(R.string.gameOver);
        alertDialogBuilder.setMessage(R.string.gameOverAsk);
        //Botones de Si o No
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        main.getGame().restart();
                        main.restartBoard();
                        dialog.dismiss();
                    }
                });
        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent("es.uam.eps.unaprimeraapp.MENUACTIVITY"));
                        dialog.dismiss();
                    }
                });
        return alertDialogBuilder.create();

    }


}
