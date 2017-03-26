package com.stef.Meetings.Task1302;

public class Main {
    public static void main(String[] args) {
        Sale check = new Sale();
        check.addLine(1,"milk",15);
        check.addLine(7,"wine",153);
        check.addLine(2,"chocolate ",25.5);
        check.addLine(3,"cheese",34.75);
        System.out.println(check.allPrice());
    }
}
