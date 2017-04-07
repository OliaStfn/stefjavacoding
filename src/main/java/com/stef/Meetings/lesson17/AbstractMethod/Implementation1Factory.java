package com.stef.Meetings.lesson17.AbstractMethod;

public class Implementation1Factory implements IServiceFactory {
    public IService createService() {
        return new Implementation1();
    }
}
