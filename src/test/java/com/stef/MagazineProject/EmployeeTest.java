package com.stef.MagazineProject;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    @Test //TODO Task 7001
    public void raiseSalaryTest() throws Exception {
        String name = "Nazar";
        String surname = "Mykhailiv";
        int year = 1990, month = 7, day = 30;
        double salary = 5000, koef = 0.10;
        Employee em = new Employee(name, surname, year, month, day, salary);

        assertEquals(salary,em.getSalary());
        em.raiseSalary();
        assertEquals(salary+=salary*koef,em.getSalary());
    }
}
