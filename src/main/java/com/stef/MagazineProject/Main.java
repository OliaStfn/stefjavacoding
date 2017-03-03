package com.stef.MagazineProject;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Human obj = new Human();
        Human object = new Human("John", "Brown",1994,11,3);
        obj.setName("Olia");
        obj.setSurname("Stefanyshyn");

        String name = object.getName();
        String surname = object.getSurname();

        // new test connection
        // new line 3

        System.out.println("Start task 3001");
        System.out.println("Finish task 3001");

        obj.showInfo();
        object.showInfo();
        //my line

        System.out.println("Start task 3002");
        System.out.println("Finish task 3002");


        Product pr1 = new Product(1, "Galaxy S", 1000, "Samsung",
                new GregorianCalendar(),
                new GregorianCalendar(2019, 2, 26));
        pr1.showExpDate();

    }
}
