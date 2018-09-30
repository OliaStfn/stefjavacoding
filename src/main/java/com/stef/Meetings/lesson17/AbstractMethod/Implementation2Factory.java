package com.stef.Meetings.lesson17.AbstractMethod;

public class Implementation2Factory implements IServiceFactory {
    public IService createService() {
        return new Implementation2();
    }
}
