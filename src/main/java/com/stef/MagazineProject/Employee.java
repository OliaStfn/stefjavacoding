package com.stef.MagazineProject;

import java.util.GregorianCalendar;
import java.util.Vector;

public class Employee extends Human {


    private GregorianCalendar date_of_begin;
    private double salary;
    private double rating;
    private Vector<Mark> marks;

    public Employee() {
        super();
        salary = 2000;
        rating = 0;
        date_of_begin = new GregorianCalendar(2016, 5, 5);
        marks= new Vector<Mark>();
    }

    public Employee(String name, String surname, int year, int month, int day, double salary, double rating) {
        super(name, surname, year, month, day);
        this.salary = salary;
        this.rating = rating;
        date_of_begin = new GregorianCalendar();
        marks= new Vector<Mark>();
    }

    public void raiseSalary() {
        this.salary += salary;
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

    public void setRating(double rating) {
        this.rating = rating;
    }

    public GregorianCalendar getDate_of_begin() {
        return date_of_begin;
    }
    public void addMark(double mark){
        marks.add(new Mark(mark));
    }
    public double generationRaiting(){
        double sum=0;
        int count=0;
        GregorianCalendar current=new GregorianCalendar();
        //for(Mark i : marks){

      //  }
        for(int i=0;i<marks.size();i++){
            if(marks.elementAt(i).getTime().get(GregorianCalendar.MONTH)==current.get(GregorianCalendar.MONTH)){
                count++;
                sum+=marks.elementAt(i).getMark();
            }
        }
        return sum/count;
    }
}
