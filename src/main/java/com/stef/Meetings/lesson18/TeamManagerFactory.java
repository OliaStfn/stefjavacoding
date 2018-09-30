package com.stef.Meetings.lesson18;

public class TeamManagerFactory implements IManagerFactory{
    public IManager createManager() {
        return new TeamManager();
    }
}
