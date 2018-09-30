package com.stef.Meetings.lesson17;

import java.util.Scanner;

public class ConsoleRead implements IRead{
    public String readFrom() {
        Scanner in=new Scanner(System.in);
        String tempLine= in.next();
        return tempLine;
    }
}
