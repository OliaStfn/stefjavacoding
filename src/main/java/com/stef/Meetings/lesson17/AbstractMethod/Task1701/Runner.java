package com.stef.Meetings.lesson17.AbstractMethod.Task1701;


public class Runner {
    public static void main(String[] args) {
        Games.Game(new CheckersFactory());
        Games.Game(new ChessFactory());
    }
}
