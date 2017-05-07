package com.stef.Meetings.lesson10;

import com.stef.MagazineProject.domain.Employee;
import com.stef.MagazineProject.domain.Manager;

public class OverridingMethodTest {
    public static void main(String[] args) {
        Employee em = new Employee();
        Manager mn = new Manager();

        System.out.println(em.toString());
        System.out.println(mn.toString());

        em.raiseSalary();
        mn.raiseSalary();

        System.out.println(em.toString());
        System.out.println(mn.toString());
    }
}
