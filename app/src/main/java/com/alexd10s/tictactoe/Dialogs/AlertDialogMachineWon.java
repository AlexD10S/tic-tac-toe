package com.alexd10s.tictactoe.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.alexd10s.tictactoe.GameIA;
import com.alexd10s.tictactoe.R;

/**
 * Created by alex on 12/05/2018.
 */

public class AlertDialogMachineWon extends DialogFragment {

    @Override
    public Dialog onCreateDialog (Bundle savedInstancedState){
        final GameIA main = (GameIA) getActivity();
        //Create AlertDialog and assign tittle and message
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(R.string.gameOverMachine);
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
