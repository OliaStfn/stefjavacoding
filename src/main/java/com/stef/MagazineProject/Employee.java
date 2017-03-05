package com.stef.MagazineProject;

public class Employee extends Human {
    private double experience, salary , koef;
    private String post;
    private double rating;

    public double getExperience() {
        return experience;
    }
    public Employee(){
        super();
        experience=0;
        salary= 2000;
        koef=1;
        post="none";
        rating=0;
    }
    public Employee(String name,String surname, int year, int month, int day,double salary)
    {
        super(name, surname, year, month, day);
        this.salary=salary;
    }
    public void raiseSalary(){
        this.salary+=salary*koef;
    }
    public void setExperience(double experience) {
        this.experience = experience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getKoef() {
        return koef;
    }

    public void setKoef(double koef) {
        this.koef = koef;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
