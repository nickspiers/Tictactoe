package com.spiersad.tictactoe;

import java.util.ArrayList;
import java.util.List;

import static com.spiersad.tictactoe.Game.PlayerTurn.*;

/**
 * Created by spiers on 5/17/13.
 */
public class Game {
    private List<GameSquares> gameBoard = new ArrayList<GameSquares>();
    private Player player1 = new Player();
    private Player player2 = new Player();
    private PlayerTurn playerTurn;

    public enum GameSquares{
        EMPTY, X, O
    }
    public enum PlayerTurn{
        PLAYER1, PLAYER2
    }

    Game() {

        for(int i =0; i < 9; i++ ) {
            gameBoard.add(GameSquares.EMPTY);
            playerTurn = PLAYER1;
        }
    }


    public List<GameSquares> resetGame(){
        for(int i = 0; i < 9; i++ ) {
            gameBoard.set(i, GameSquares.EMPTY);
        }
        return gameBoard;
    }


    public String checkGame(){

        if (gameBoard.get(0).equals(GameSquares.X) && gameBoard.get(1).equals(GameSquares.X) && gameBoard.get(2).equals(GameSquares.X)){
            player1.addWin();
            return "Player 1";
        }
        else if (gameBoard.get(2).equals(GameSquares.X) && gameBoard.get(5).equals(GameSquares.X) && gameBoard.get(8).equals(GameSquares.X)){
            player1.addWin();
            return "Player 1";
        }
        else if (gameBoard.get(0).equals(GameSquares.X) && gameBoard.get(3).equals(GameSquares.X) && gameBoard.get(6).equals(GameSquares.X)){
            player1.addWin();
            return "Player 1";
        }
        else if (gameBoard.get(6).equals(GameSquares.X) && gameBoard.get(7).equals(GameSquares.X) && gameBoard.get(8).equals(GameSquares.X)){
            player1.addWin();
            return "Player 1";
        }
        else if (gameBoard.get(0).equals(GameSquares.X) && gameBoard.get(4).equals(GameSquares.X) && gameBoard.get(8).equals(GameSquares.X)){
            player1.addWin();
            return "Player 1";
        }
        else if (gameBoard.get(2).equals(GameSquares.X) && gameBoard.get(4).equals(GameSquares.X) && gameBoard.get(6).equals(GameSquares.X)){
            player1.addWin();
            return "Player 1";
        }
        else if (gameBoard.get(3).equals(GameSquares.X) && gameBoard.get(4).equals(GameSquares.X) && gameBoard.get(5).equals(GameSquares.X)){
            player1.addWin();
            return "Player 1";
        }
        else if (gameBoard.get(1).equals(GameSquares.X) && gameBoard.get(4).equals(GameSquares.X) && gameBoard.get(7).equals(GameSquares.X)){
            player1.addWin();
            return "Player 1";
        }
        else if (gameBoard.get(0).equals(GameSquares.O) && gameBoard.get(1).equals(GameSquares.O) && gameBoard.get(2).equals(GameSquares.O)){
            player1.addWin();
            return "Player 2";
        }
        else if (gameBoard.get(2).equals(GameSquares.O) && gameBoard.get(5).equals(GameSquares.O) && gameBoard.get(8).equals(GameSquares.O)){
            player2.addWin();
            return "Player 2";
        }
        else if (gameBoard.get(0).equals(GameSquares.O) && gameBoard.get(3).equals(GameSquares.O) && gameBoard.get(6).equals(GameSquares.O)){
            player2.addWin();
            return "Player 2";
        }
        else if (gameBoard.get(6).equals(GameSquares.O) && gameBoard.get(7).equals(GameSquares.O) && gameBoard.get(8).equals(GameSquares.O)){
            player2.addWin();
            return "Player 2";
        }
        else if (gameBoard.get(0).equals(GameSquares.O) && gameBoard.get(4).equals(GameSquares.O) && gameBoard.get(8).equals(GameSquares.O)){
            player2.addWin();
            return "Player 2";
        }
        else if (gameBoard.get(2).equals(GameSquares.O) && gameBoard.get(4).equals(GameSquares.O) && gameBoard.get(6).equals(GameSquares.O)){
            player2.addWin();
            return "Player 2";
        }
        else if (gameBoard.get(3).equals(GameSquares.O) && gameBoard.get(4).equals(GameSquares.O) && gameBoard.get(5).equals(GameSquares.O)){
            player2.addWin();
            return "Player 2";
        }
        else if (gameBoard.get(1).equals(GameSquares.O) && gameBoard.get(4).equals(GameSquares.O) && gameBoard.get(7).equals(GameSquares.O)){
            player2.addWin();
            return "Player 2";
        }
        else if ((gameBoard.get(0).equals(GameSquares.O) || gameBoard.get(0).equals(GameSquares.X)) &&
                (gameBoard.get(1).equals(GameSquares.O) || gameBoard.get(1).equals(GameSquares.X)) &&
                (gameBoard.get(2).equals(GameSquares.O) || gameBoard.get(2).equals(GameSquares.X)) &&
                (gameBoard.get(3).equals(GameSquares.O) || gameBoard.get(3).equals(GameSquares.X)) &&
                (gameBoard.get(4).equals(GameSquares.O) || gameBoard.get(4).equals(GameSquares.X)) &&
                (gameBoard.get(5).equals(GameSquares.O) || gameBoard.get(5).equals(GameSquares.X)) &&
                (gameBoard.get(6).equals(GameSquares.O) || gameBoard.get(6).equals(GameSquares.X)) &&
                (gameBoard.get(7).equals(GameSquares.O) || gameBoard.get(7).equals(GameSquares.X)) &&
                (gameBoard.get(8).equals(GameSquares.O) || gameBoard.get(8).equals(GameSquares.X))){
            return "No one";
        }
        else
            return "none";
    }


    public GameSquares playGame(int squareSelected){
        GameSquares returned;
        if (gameBoard.get(squareSelected).equals(GameSquares.O) || gameBoard.get(squareSelected).equals(GameSquares.X)){
            return gameBoard.get(squareSelected);
        }
        if (playerTurn.equals(PLAYER1)){
            gameBoard.set(squareSelected, GameSquares.X);
            playerTurn = PLAYER2;
            returned = GameSquares.X;
        }
        else {
            gameBoard.set(squareSelected, GameSquares.O);
            playerTurn = PLAYER1;
            returned = GameSquares.O;
        }
        return returned;
    }
}
