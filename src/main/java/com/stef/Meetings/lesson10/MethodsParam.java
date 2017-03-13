package com.stef.Meetings.lesson10;

import com.stef.MagazineProject.Employee;

public class MethodsParam {
    public static void main(String[] args) {
        double percent = 10;
        trippPercent(percent);
        System.out.println("percent = " + percent);


        Employee em = new Employee();
        System.out.println("Employee salary = " + em.getSalary());
        tp(em);
        System.out.println("Employee salary = " + em.getSalary());
        Employee em2 = new Employee();

        System.out.println("before");
        System.out.println(em.toString());
        System.out.println(em2.toString());

        swap(em, em2);
        System.out.println("after");
        System.out.println(em.toString());
        System.out.println(em2.toString());




    }

    public static void trippPercent(double x) {
        x = 3 * x;
    }

    public static void tp(Employee x) {
        x.setSalary(x.getSalary() * 3);
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}
