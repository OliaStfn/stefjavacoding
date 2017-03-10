package com.stef.MagazineProject;

import java.util.GregorianCalendar;

public class Mark {
    private double mark;
    private GregorianCalendar time;

    public Mark() {
        mark = 0;
        time = new GregorianCalendar();
    }

    public Mark(double mark) {
        this.mark = mark;
        time = new GregorianCalendar();
    }

    public double getMark() {
        return mark;
    }

    public GregorianCalendar getTime() {
        return time;
    }
}
