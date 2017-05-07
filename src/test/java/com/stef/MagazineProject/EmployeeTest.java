package com.stef.MagazineProject;

import com.stef.MagazineProject.domain.Employee;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void getExperienceTest() throws Exception {
        String name = "Nazar";
        String surname = "Mykhailiv";
        int year = 1990, month = 7, day = 30;
        double salary = 5000, koef = 0.10, rating = 1;
        //Employee em = new Employee(name, surname, year, month, day, salary, rating);
        Employee em = new Employee();
        //Thread.sleep(70000);
        em.getExperience();
    }

    @Test //TODO Task 7001
    public void raiseSalaryTest() throws Exception {
        String name = "Nazar";
        String surname = "Mykhailiv";
        int year = 1990, month = 7, day = 30;
        double salary = 5000, koef = 0.10, rating = 1;
        Employee em = new Employee(name, surname, year, month, day, salary);

        assertEquals(salary, em.getSalary(), 0);
        em.raiseSalary();
        assertEquals(salary += salary * koef, em.getSalary());
    }

}
