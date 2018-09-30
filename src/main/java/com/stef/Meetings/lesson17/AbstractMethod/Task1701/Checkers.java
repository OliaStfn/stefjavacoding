package com.stef.Meetings.lesson17.AbstractMethod.Task1701;

public class Checkers implements IGame{
    public int moves;
    public static final int MOVES=1;

    public Checkers(int moves) {
        this.moves = moves;
    }

    public boolean move() {
        if(moves<MOVES){

            return true;
        }
        return false;
    }
}
