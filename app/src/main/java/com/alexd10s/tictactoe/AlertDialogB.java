package com.alexd10s.tictactoe;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.content.DialogInterface;
/**
 * Message when finished the game
 */
public class AlertDialogB extends DialogFragment{
    @Override
    public Dialog onCreateDialog (Bundle savedInstancedState){
        final Game main = (Game) getActivity();
        //Create AlertDialog and assign tittle and message
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(R.string.gameOverB);
        alertDialogBuilder.setMessage(R.string.gameOverAsk);
        //yes/not buttons
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
                        startActivity(new Intent("com.alexd10s.tictactoe.MAINMENU"));
                        dialog.dismiss();
                    }
                });
        return alertDialogBuilder.create();

    }


}
