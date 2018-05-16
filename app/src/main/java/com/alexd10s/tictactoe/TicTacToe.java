package com.alexd10s.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 04/11/2015.
 */
public class TicTacToe {
    //Board can be 0 if it is empty, 1 occupied by player1 or 2 occupied by player2
    private int [][] board;

    public TicTacToe(){
        board= new int [3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=0;
            }
        }
    }
    public boolean Winner(int player){
        if(board[0][0]==player && board[0][1]==player && board[0][2]==player){
            return true;
        }
        if(board[1][0]==player && board[1][1]==player && board[1][2]==player){
            return true;
        }
        if(board[2][0]==player && board[2][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][0]==player && board[1][0]==player && board[2][0]==player){
            return true;
        }
        if(board[0][1]==player && board[1][1]==player && board[2][1]==player){
            return true;
        }
        if(board[0][2]==player && board[1][2]==player && board[2][2]==player){
            return true;
        }
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
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
    public boolean play(int i,int j,int player){
        if (board[i][j] == 0){
            board[i][j] = player;
            return true;
        }
        else {
            return false;
        }
    }

    public void playIA(int i,int j,int player){
            board[i][j] = player;
    }

    public int getValuePosition(int i, int j){
        return board[i][j];
    }


    public boolean nextWillWin(int i, int j, int player){

        if(board[0][0]==player && board[0][1]==player && i==0 && j==2){
            return true;
        }
        if(board[0][0]==player && board[0][2]==player && i==0 && j==1){
            return true;
        }
        if(board[0][1]==player && board[0][2]==player && i==0 && j==0){
            return true;
        }

        if(board[1][0]==player && board[1][1]==player && i==1 && j==2){
            return true;
        }
        if(board[1][0]==player && board[1][2]==player && i==1 && j==1){
            return true;
        }
        if(board[1][1]==player && board[1][2]==player && i==1 && j==0){
            return true;
        }

        if(board[2][0]==player && board[2][1]==player && i==2 && j==2){
            return true;
        }
        if(board[2][0]==player && board[2][2]==player && i==2 && j==1){
            return true;
        }
        if(board[2][1]==player && board[2][2]==player && i==2 && j==0){
            return true;
        }

        if(board[0][0]==player && board[1][0]==player && i==2 && j==0){
            return true;
        }
        if(board[0][0]==player && board[2][0]==player && i==1 && j==0){
            return true;
        }
        if(board[1][0]==player && board[2][0]==player && i==0 && j==0){
            return true;
        }


        if(board[0][1]==player && board[1][1]==player && i==2 && j==1){
            return true;
        }
        if(board[0][1]==player && board[2][1]==player && i==1 && j==1){
            return true;
        }
        if(board[1][1]==player && board[2][1]==player && i==0 && j==1){
            return true;
        }

        if(board[0][2]==player && board[1][2]==player && i==2 && j==2){
            return true;
        }
        if(board[0][2]==player && board[2][2]==player && i==1 && j==2){
            return true;
        }
        if(board[1][2]==player && board[2][2]==player && i==0 && j==2){
            return true;
        }

        if(board[0][0]==player && board[1][1]==player && i==2 && j==2){
            return true;
        }
        if(board[0][0]==player && board[2][2]==player && i==1 && j==1){
            return true;
        }
        if(board[1][1]==player && board[2][2]==player && i==0 && j==0){
            return true;
        }

        if(board[0][2]==player && board[1][1]==player && i==2 && j==0){
            return true;
        }
        if(board[0][2]==player && board[2][0]==player && i==1 && j==1){
            return true;
        }
        if(board[1][1]==player && board[2][0]==player && i==0 && j==2){
            return true;
        }
        else return false;
    }


    public List<Integer> emptyIndexies(){
        int positionInteger = 0;
        List<Integer> listAvailable = new ArrayList<Integer>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                if (board[i][j] == 0) {
                    listAvailable.add(i);
                }
                positionInteger = positionInteger + 1;
            }
        }
        return listAvailable;
    }
}
