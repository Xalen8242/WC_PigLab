package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    PigGameState pigGS;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        pigGS = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        return (playerIdx == pigGS.getID());


    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if(action instanceof PigHoldAction){

                if(pigGS.getID() == 0){
                    pigGS.setP1Score(pigGS.getP1Score() + pigGS.getRunningTotal());
                    pigGS.setRunningTotal(0);
                    if(this.players.length > 1) {
                        pigGS.setID(1);
                    }
                }
                else{
                    pigGS.setP2Score( pigGS.getP2Score() + pigGS.getRunningTotal());
                    pigGS.setRunningTotal(0);

                        pigGS.setID(0);

                }


            return true;
        }
        else if (action instanceof PigRollAction){
            Random rand = new Random();
            pigGS.setDieValue(rand.nextInt(6)+1);
            if(pigGS.getDieValue() != 1){
                pigGS.setRunningTotal(pigGS.getDieValue() + pigGS.getRunningTotal());

            }
            else{
                pigGS.setRunningTotal(0);
                if(pigGS.getID() == 0){
                    if(this.players.length > 1) {
                        pigGS.setID(1);
                    }

                }
                else{
                    pigGS.setID(0);
                }
            }


            return true;
        }
        else{
            return false;
        }

    //makeMove
    }

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState copy = new PigGameState(pigGS);

        p.sendInfo(copy);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    //add rest of text
    protected String checkIfGameOver() {
        if(pigGS.getP1Score() >= 50){
            return "Player  " + this.playerNames[0] + " wins with " + pigGS.getP1Score() + " points!" ;
        }
        else if(pigGS.getP2Score() >= 50){
            return "Player " + this.playerNames[1] + " wins with " + pigGS.getP2Score() + " points!";
        }
        return null;
    }

}// class PigLocalGame
