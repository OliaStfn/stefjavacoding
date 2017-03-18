package com.stef.MagazineProject;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ManagerTest {
    @Test //TODO Task 1102
    public void setBonus() throws Exception {
        ArrayList<Employee> staff = new ArrayList<Employee>();
        staff.add(new Employee());
        staff.add(new Manager());

        int salary = 5000;

        for (Employee human : staff) {
            human.setSalary(salary);
            human.setBonus();
        }
        assertEquals(salary * 1.10, staff.get(0).getSalary(), 0);
        assertEquals(salary * 1.25, staff.get(1).getSalary(), 0);
    }

}