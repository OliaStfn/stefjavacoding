package com.stef.Meetings.lesson23_Generics;

public class SimpleGen<P,V> {
    private P obj1;
    private V obj2;

    public SimpleGen(P obj1, V obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public String toString() {
        return "P is " + obj1.getClass().getName()
                + "\nV is "+ obj2.getClass().getName();
    }
}
