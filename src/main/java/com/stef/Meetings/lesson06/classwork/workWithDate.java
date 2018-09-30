package com.stef.Meetings.lesson06.classwork;

        import java.util.Date;
        import java.util.GregorianCalendar;

public class workWithDate {
    public static void main(String[] args) {
        Date current = new Date();
        GregorianCalendar currentDate = new GregorianCalendar();
        GregorianCalendar expDate = new GregorianCalendar(2020,12,25,15,20);
        System.out.println("Current date is :" + current.toString());
        System.out.println("Current date from GC is :" + currentDate.getTime());
        System.out.println("Exp date from is :" + expDate.getTime());
        //System.out.println("Exp year :" + expDate.get);

        System.out.println(current.getTime());
    }
}
