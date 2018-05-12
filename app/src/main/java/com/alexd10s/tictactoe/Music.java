package com.alexd10s.tictactoe;

import android.media.MediaPlayer;
import android.content.Context;

/**
 * Class for manage the music
 */
public class Music {
    //MediaPlayer for control audio and video
    private static MediaPlayer player;

    /**
     * Method for start the music
     */
    public static void play(Context context,int id){
        //Create object with an id which point .mp3 file
        player= MediaPlayer.create(context,id);
        //loop forever if is true
        player.setLooping(true);
        player.start();
    }

    /**
     * Method for stop the music
     */
    public static void stop(Context context){
        if(player != null){
            player.stop();
            player.release();
            player = null;
        }
    }
}
