package com.stef.MagazineProject;


import java.util.GregorianCalendar;

public abstract class Human {
    private String name;
    private String surname;
    private GregorianCalendar bornDate;

    public void setBornDate(GregorianCalendar bornDate) {
        try {
            this.bornDate = bornDate;
        }catch (NullPointerException e){
            System.out.println("Exception: "+e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public GregorianCalendar getBornDate() {
        return bornDate;
    }

    public int getAge() {
        int year;
        GregorianCalendar current = new GregorianCalendar();
        year = current.get(GregorianCalendar.YEAR) - bornDate.get(GregorianCalendar.YEAR);
        if (current.get(GregorianCalendar.MONTH) < bornDate.get(GregorianCalendar.MONTH)) {
            year--;
        }
        if (current.get(GregorianCalendar.MONTH) == bornDate.get(GregorianCalendar.MONTH) &&
                current.get(GregorianCalendar.DATE) < bornDate.get(GregorianCalendar.DATE)) {
            year--;
        }
        return year;
    }

    //public abstract void showInformation();
}