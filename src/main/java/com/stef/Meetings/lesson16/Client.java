package com.stef.Meetings.lesson16;

public abstract class Client implements NewCallBack, TypeFeeBack {

    public void showArgs(int args){
        System.out.println("Method in class Callback with argument :"+args);
    }

    public void feeback(int args) {
        System.out.println("Method feedBack in class Client with argument :"+args);
    }
}
