package com.stef.Meetings.lesson17.AbstractMethod;

public class Factory {
    public static void callService(IServiceFactory factory){
        IService service = factory.createService();
        service.method1();
        service.method2();
    }
}
