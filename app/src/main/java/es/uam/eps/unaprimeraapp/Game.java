package es.uam.eps.unaprimeraapp;

/**
 * Created by alex on 04/11/2015.
 */
public class Game {
    //Board puede ser 0,1 o 2 dependiendo si es vacio, jugador 1 o jugador 2
    private int [][] board;

    public Game(){
        board= new int [3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=0;
            }
        }
    }
    public boolean Winner(int player){
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][1]==player && board[1][1]==player && board[2][1]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        if(board[1][0]==player && board[1][1]==player && board[1][2]==player){
            return true;
        }
        if(board[0][0]==player && board[1][0]==player && board[2][0]==player){
            return true;
        }
        if(board[0][2]==player && board[1][2]==player && board[2][2]==player){
            return true;
        }
        if(board[0][0]==player && board[0][1]==player && board[0][2]==player){
            return true;
        }
        if(board[2][0]==player && board[2][1]==player && board[2][2]==player){
            return true;
        }
        else return false;
    }
    public boolean isFull(){
        boolean full=true;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==0){
                    full=false;
                }
            }
        }
        return full;
    }
    public void restart(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=0;

            }
        }
    }
    public void play(int i,int j,int player){
        board[i][j]=player;
    }
}
