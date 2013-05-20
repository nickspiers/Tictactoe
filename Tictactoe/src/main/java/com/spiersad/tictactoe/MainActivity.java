package com.spiersad.tictactoe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private Game game = new Game();
    private List<ImageView> UIBoard = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UIBoard.add((ImageView) findViewById(R.id.topLeft));
        UIBoard.add((ImageView) findViewById(R.id.topCenter));
        UIBoard.add((ImageView) findViewById(R.id.topRight));
        UIBoard.add((ImageView) findViewById(R.id.centerLeft));
        UIBoard.add((ImageView) findViewById(R.id.centerCenter));
        UIBoard.add((ImageView) findViewById(R.id.centerRight));
        UIBoard.add((ImageView) findViewById(R.id.bottomLeft));
        UIBoard.add((ImageView) findViewById(R.id.bottomCenter));
        UIBoard.add((ImageView) findViewById(R.id.bottomRight));
        Button reset = (Button) findViewById(R.id.reset);

        for(int i = 0;i < UIBoard.size(); i++){
            final int finalI = i;
            UIBoard.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (game.playGame(finalI) == Game.GameSquares.X)
                        UIBoard.get(finalI).setImageDrawable(getResources().getDrawable(R.drawable.letterx));
                    else
                        UIBoard.get(finalI).setImageDrawable(getResources().getDrawable(R.drawable.lettero));
                    check();
                }

            });
        }
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.resetGame();
                for (int i = 0; i < UIBoard.size(); i++)
                    UIBoard.get(i).setImageDrawable(getResources().getDrawable(R.drawable.empty));
            }
        });
    }
    public void check() {
        String winner = game.checkGame();
        if (winner.equals("Player 1") || winner.equals("Player 2") || winner.equals("No one")){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("WIN")
                    .setMessage(winner + " is the winner.")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            game.resetGame();
            for (int i = 0; i < UIBoard.size(); i++)
                UIBoard.get(i).setImageDrawable(getResources().getDrawable(R.drawable.empty));
        }
    }
}
