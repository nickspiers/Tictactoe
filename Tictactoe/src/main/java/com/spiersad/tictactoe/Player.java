package com.spiersad.tictactoe;

/**
 * Created by spiers on 5/17/13.
 */
class Player {
    private int numberOfWins;
    Player(){
        numberOfWins = 0;
    }
    public int getNumberOfWins(){
        return numberOfWins;
    }
    public void setNumberOfWins(int wins){
        numberOfWins = wins;
    }
    public void addWin(){
        numberOfWins++;
    }
}