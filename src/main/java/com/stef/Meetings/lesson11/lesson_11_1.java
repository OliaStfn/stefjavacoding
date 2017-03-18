package com.stef.Meetings.lesson11;

import com.stef.MagazineProject.Employee;
import com.stef.MagazineProject.Manager;
import com.stef.MagazineProject.Officer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class lesson_11_1 {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<Employee>();

        staff.add(new Employee());
        staff.add(new Manager());
        staff.add(new Employee());
        staff.add(new Employee());
        staff.add(new Manager());
        staff.add(new Manager());


        for (Employee human : staff) {

            if (human instanceof Manager){
                Manager mn = (Manager)human;
                human.raiseSalary();
                mn.setPhone("0971073443");
            }
            System.out.println(human.toString());
        }


        Manager bigBoss = (Manager) staff.get(1);
        bigBoss.setPhone("0971073443");





    }
}
