package com.stef.MagazineProject.domain;

import java.util.ArrayList;
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

    public static ArrayList<Mark> create(){
        return new ArrayList<Mark>();
    }

    public static Mark createMark(){
        return new Mark();
    }

    public double getMark() {
        return mark;
    }

    public GregorianCalendar getTime() {
        return time;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
