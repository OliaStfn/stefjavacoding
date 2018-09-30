package com.stef.Meetings.lesson25;

public class GenConstruct {
    private double value;

    <T extends Number> GenConstruct(T arg) {
        value = arg.doubleValue();
    }

    @Override
    public String toString() {
        return "GenConstruct{" +
                "value=" + value +
                '}';
    }

    public static void main(String[] args) {
        GenConstruct gn1= new GenConstruct(100);
        GenConstruct gn2 = new GenConstruct(1000.5);
        //GenConstruct gn3 = new GenConstruct("dsf");
    }
}
