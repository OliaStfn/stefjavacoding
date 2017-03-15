package com.stef.MagazineProject;

public class Manager extends Employee {


    @Override
    public void raiseSalary() {
        setSalary(getSalary()+getSalary()*0.15);
    }
}
