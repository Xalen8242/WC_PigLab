package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
    private int ID = 0;
    private int p1Score = 0;
    private int p2Score = 0;
    private int runningTotal = 0;
    private int dieValue = 0;


    public PigGameState(){
        this.ID = 0;
        this.p1Score = 0;
        this.p2Score = 0;
        this.runningTotal = 0;
        this.dieValue = 0;
    }
    public PigGameState(PigGameState name){

        this.ID = name.ID;
        this.p1Score = name.p1Score;
        this.p2Score = name.p2Score;
        this.runningTotal = name.runningTotal;
        this.dieValue = name.dieValue;

    }

    //getters
    public int getID(){
        return this.ID;
    }
    public int getP1Score(){
        return this.p1Score;
    }
    public int getP2Score(){
        return this.p2Score;
    }
    public int getRunningTotal(){
        return this.runningTotal;
    }
    public int getDieValue(){
        return this.dieValue;
    }

    //setters
    public void setID(int set){
        this.ID = set;
    }
    public void setP1Score(int set){
        this.p1Score = set;
    }
    public void setP2Score(int set){
       this.p2Score = set;
    }
    public void setRunningTotal(int set){
        this.runningTotal = set;
    }
    public void setDieValue(int set){
         this.dieValue = set;
    }

}
