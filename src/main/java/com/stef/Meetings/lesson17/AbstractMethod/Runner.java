package com.stef.Meetings.lesson17.AbstractMethod;

public class Runner {
    public static void main(String[] args) {
        Factory.callService(new Implementation1Factory());
        Factory.callService(new Implementation2Factory());
    }
}
