package es.uam.eps.unaprimeraapp;

import android.media.MediaPlayer;
import android.content.Context;

/**
 * Clase para controlar la musica
 */
public class Music {
    //MediaPlayer controla audio y video
    private static MediaPlayer player;

    public static void play(Context context,int id){
        //Crea objeto con un id que apunta al fichero .mp3
        player= MediaPlayer.create(context,id);
        //Si es true se repite indefinidamente
        player.setLooping(true);
        player.start();
    }
    public static void stop(Context context){
        if(player != null){
            player.stop();
            player.release();
            player = null;
        }
    }
}
