package com.stef.MagazineProject;


import java.util.GregorianCalendar;
import java.util.Scanner;

public abstract class Human {
    private String name;
    private String surname;
    private GregorianCalendar bornDate;

    public Human() {
        name = "name";
        surname = "surname";
        bornDate = new GregorianCalendar(1990, 01, 01);
    }

    public Human(String name, String surname, int year, int month, int day) {
        setName(name);
        setSurname(surname);
        bornDate = new GregorianCalendar(year, month, day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введіть ваше імя:");
        this.name = input.next();
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