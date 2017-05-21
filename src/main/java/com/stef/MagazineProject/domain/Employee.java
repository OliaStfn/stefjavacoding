package com.stef.MagazineProject.domain;

import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Employee extends Human {
    private static int nextId = 1;

    private int id;
    private GregorianCalendar date_of_begin;
    private double salary;
    private double rating;
    private ArrayList<Mark> marks;

    public Employee() {
        setName("name");
        setSurname("surname");
        setBornDate(new GregorianCalendar(1990, 01, 01));
        setId();
        salary = 2000;
        rating = 0;
        date_of_begin = new GregorianCalendar(2016, 5, 5);
        marks = Mark.create();
    }

    public Employee(String name, String surname, int year, int month, int day, double salary) {
        setName(name);
        setSurname(surname);
        setBornDate(new GregorianCalendar(year, month, day));
        setId();
        this.salary = salary;
        date_of_begin = new GregorianCalendar();
        marks = Mark.create();
    }

    public void raiseSalary() {
        this.salary += salary * 0.10;
    }

    public void getExperience() {
        GregorianCalendar currentDate = new GregorianCalendar();
        int year, month, date, hour, minutes;

        year = currentDate.get(GregorianCalendar.YEAR)
                - date_of_begin.get(GregorianCalendar.YEAR);
        month = currentDate.get(GregorianCalendar.MONTH)
                - date_of_begin.get(GregorianCalendar.MONTH);
        date = currentDate.get(GregorianCalendar.DATE)
                - date_of_begin.get(GregorianCalendar.DATE);
        hour = currentDate.get(GregorianCalendar.HOUR)
                - date_of_begin.get(GregorianCalendar.HOUR);
        minutes = currentDate.get(GregorianCalendar.MINUTE)
                - date_of_begin.get(GregorianCalendar.MINUTE);

        if (month < 0) {
            month = 0;
        }
        System.out.println(" year = " + year +
                " month = " + month +
                " date = " + date +
                " hour = " + hour +
                " minutes = " + minutes);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getRating() {
        return rating;
    }

    public GregorianCalendar getDate_of_begin() {
        return date_of_begin;
    }

    public void addMark(double valuation) {
        Mark mark = Mark.createMark();
        mark.setMark(valuation);
        marks.add(mark);
    }

    public void generationRating() {
        double sum = 0;
        int count = 0;
        GregorianCalendar current = new GregorianCalendar();

        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i).getTime().get(GregorianCalendar.MONTH) == current.get(GregorianCalendar.MONTH)) {
                count++;
                sum += marks.get(i).getMark();
            }
        }
        rating = sum / count;
    }

    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name: " + getName() +
                ", Date of begin:"+getDate_of_begin().get(GregorianCalendar.DATE) +
                "." + getDate_of_begin().get(GregorianCalendar.MONTH) +
                "." + getDate_of_begin().get(GregorianCalendar.YEAR) +
                ", Surname: " + getSurname() +
                ", Salary: " + salary +
                ", Rating: " + rating +
                '}';
    }

    public void setBonus() {
        salary += salary * 0.1;
    }


}
