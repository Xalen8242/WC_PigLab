package edu.up.cs301.pig;

import android.graphics.Color;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.GameState;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigSmartComputerPlayer extends GameComputerPlayer {
    Random rand = new Random();

    /**
     * ctor does nothing extra
     */
    public PigSmartComputerPlayer(String name) {
        super(name);

    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if(!(info instanceof PigGameState)) {
            return;
        }


        PigGameState copy = (PigGameState) info;
        if(copy.getID() == playerNum){

            if(copy.getP2Score() >= 40 || copy.getP1Score() >= 40) {
                if (copy.getID() == 0) {
                    if (copy.getP1Score() >= 40) {
                        if (copy.getRunningTotal() > 3) {
                            PigHoldAction hold = new PigHoldAction(this);
                            game.sendAction(hold);
                        } else {
                            PigRollAction roll = new PigRollAction(this);
                            game.sendAction(roll);
                        }
                    } else if (copy.getP2Score() >= 40) {
                        if (copy.getRunningTotal() > 10) {
                            PigHoldAction hold = new PigHoldAction(this);
                            game.sendAction(hold);
                        } else {
                            PigRollAction roll = new PigRollAction(this);
                            game.sendAction(roll);
                        }
                    }
                }
               else {
                    if (copy.getP2Score() >= 40) {
                        if (copy.getRunningTotal() > 3) {
                            PigHoldAction hold = new PigHoldAction(this);
                            game.sendAction(hold);
                        } else {
                            PigRollAction roll = new PigRollAction(this);
                            game.sendAction(roll);
                        }

                    } else if (copy.getP1Score() >= 40) {
                        if (copy.getRunningTotal() > 10) {
                            PigHoldAction hold = new PigHoldAction(this);
                            game.sendAction(hold);
                        } else {
                            PigRollAction roll = new PigRollAction(this);
                            game.sendAction(roll);
                        }
                    }
                }

            }

                else if(Math.abs(copy.getP1Score() - copy.getP2Score()) > 10){
                    if(copy.getRunningTotal() > 10){
                        PigHoldAction hold = new PigHoldAction(this);
                        game.sendAction(hold);
                    }
                    else{
                        PigRollAction roll = new PigRollAction(this);
                        game.sendAction(roll);
                    }
                }
                else{
                    if(copy.getRunningTotal() > 5){
                        PigHoldAction hold = new PigHoldAction(this);
                        game.sendAction(hold);
                    }
                    else{
                        PigRollAction roll = new PigRollAction(this);
                        game.sendAction(roll);
                    }
                }

            }
        else{
            return;
        }
    }//receiveInfo

}
