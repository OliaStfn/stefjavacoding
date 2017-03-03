package com.stef.MagazineProject;


import java.util.GregorianCalendar;

public class Human {
    private String name;
    private String surname;
    GregorianCalendar bornDate;

    public Human() {
        name = "name";
        surname = "surname";


    public Human(String name, String surname) {
            setName(name);
            setSurname(surname);
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

    //start Task 6001

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Birthday: " +);
    }
}