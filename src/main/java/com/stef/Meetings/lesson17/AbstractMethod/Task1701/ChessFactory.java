package com.stef.Meetings.lesson17.AbstractMethod.Task1701;

public class ChessFactory implements IGameFactory{
    public IGame getGame() {
        IGame pv=new Chess(2);
        return pv;
    }
}
