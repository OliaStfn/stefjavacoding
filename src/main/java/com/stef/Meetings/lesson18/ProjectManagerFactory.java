package com.stef.Meetings.lesson18;

public class ProjectManagerFactory implements IManagerFactory {
    public IManager createManager() {
        return new ProjectManager();
    }
}
