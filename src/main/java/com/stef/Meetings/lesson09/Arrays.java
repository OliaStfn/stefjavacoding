package com.stef.Meetings.lesson09;

import com.stef.MagazineProject.domain.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int newSize;

        System.out.print("Put size of array:");
        newSize = input.nextInt();

        ArrayList<Employee> stafff = new ArrayList<Employee>();

        for (int i = 0; i < newSize; i++) {
            stafff.add(new Employee());
        }

        stafff.remove(2);
        stafff.add(new Employee());


        for (Employee worker : stafff) {
            System.out.println(worker.toString());
        }


        System.out.println("Next id number is "+Employee.getNextId());

    }
}
