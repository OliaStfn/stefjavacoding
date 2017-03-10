package com.stef.MagazineProject;


import java.util.GregorianCalendar;

public class Human {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public GregorianCalendar getBornDate() {
        return bornDate;
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bornDate=" + bornDate +
                '}';
    }
}