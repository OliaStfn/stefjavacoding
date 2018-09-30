package com.stef.Meetings.lesson17;

public class Runner {
    public static void main(String[] args) {
        IRead reder = new ConsoleRead();
        Iprint printer = new ConsolePrint();
        Replacer replacer = new Replacer(reder, printer);
        replacer.replace();
    }
}
