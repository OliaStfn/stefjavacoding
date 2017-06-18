package com.stef.Meetings.lesson11;

import com.stef.MagazineProject.domain.Employee;
import com.stef.MagazineProject.domain.Manager;

import java.util.ArrayList;

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
              //  human.raiseSalary();
                mn.setPhone("0971073443");
            }
            System.out.println(human.toString());
        }


        Manager bigBoss = (Manager) staff.get(1);
        bigBoss.setPhone("0971073443");





    }
}
