package com.stef.Meetings.lesson17;

public class Replacer {
    private IRead reader;
    private Iprint printer;

    public Replacer(IRead reader, Iprint printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public void replace(){
        String readLine = reader.readFrom();
        String repLine = readLine.replace("1", "a");
        printer.print(repLine);
    }
}
