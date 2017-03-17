package com.stef.MagazineProject;

public class Manager extends Employee {

    private int phone;
    private String department;

    public Manager(int phone, String department) {
        super();
        this.phone = phone;
        this.department = department;
    }

    public Manager(String name, String surname, int year, int month, int day, double salary, int phone, String department) {
        super(name, surname, year, month, day, salary);
        this.phone = phone;
        this.department = department;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void raiseSalary() {
        setSalary(getSalary() + getSalary() * 0.15);
    }

    @Override
    public void setBonus() {
        setSalary(getSalary() + getSalary() * 0.2);
    }
}
