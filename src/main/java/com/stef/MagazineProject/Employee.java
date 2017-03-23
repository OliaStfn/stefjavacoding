package com.stef.MagazineProject;

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
        marks = new ArrayList<Mark>();
    }

    public Employee(String name, String surname, int year, int month, int day, double salary) {
        setName(name);
        setSurname(surname);
        setBornDate(new GregorianCalendar(year, month, day));
        setId();
        this.salary = salary;
        date_of_begin = new GregorianCalendar();
        marks = new ArrayList<Mark>();
    }

    public void raiseSalary() {
        this.salary += salary * 0.10;
    }

    public void getExperience() {
        GregorianCalendar curentDate = new GregorianCalendar();
        int year, month, date, hour, minutes;

        year = curentDate.get(GregorianCalendar.YEAR)
                - date_of_begin.get(GregorianCalendar.YEAR);
        month = curentDate.get(GregorianCalendar.MONTH)
                - date_of_begin.get(GregorianCalendar.MONTH);
        date = curentDate.get(GregorianCalendar.DATE)
                - date_of_begin.get(GregorianCalendar.DATE);
        hour = curentDate.get(GregorianCalendar.HOUR)
                - date_of_begin.get(GregorianCalendar.HOUR);
        minutes = curentDate.get(GregorianCalendar.MINUTE)
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

    public void addMark(double mark) {
        marks.add(new Mark(mark));
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
                "name=" + getName() +
                "surname=" + getSurname() +
                "id=" + getId() +
                ", salary=" + salary +
                ", rating=" + rating +
                '}';
    }

    public void setBonus() {
        salary += salary * 0.1;
    }


}
