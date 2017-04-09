package com.stef.Meetings.lesson17.AbstractMethod.Task1701;

public class CheckersFactory implements IGameFactory{
    public IGame getGame() {
            IGame hm=new Checkers(4);

        return hm;
    }
}
