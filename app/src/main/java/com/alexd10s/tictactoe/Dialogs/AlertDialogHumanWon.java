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

public class AlertDialogHumanWon extends DialogFragment {


    @Override
    public Dialog onCreateDialog (Bundle savedInstancedState){
        final GameIA main = (GameIA) getActivity();
        //create AlertDialog with message and title
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(R.string.gameOverHuman);
        alertDialogBuilder.setMessage(R.string.gameOverAsk);
        //Buttons yes/not
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