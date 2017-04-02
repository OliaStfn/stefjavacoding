package com.stef.Meetings.lesson16;

public class Runner {
    public static void main(String[] args) {
        Callback someObj = new ClientC();
        Callback someObjB = new ClientB();

        someObj.callback(2);
        someObjB.callback(2);
    }
}
