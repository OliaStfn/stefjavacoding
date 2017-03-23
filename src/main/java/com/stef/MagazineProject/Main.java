package com.stef.MagazineProject;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
       // Human obj = new Human();
       // Human object = new Human("John", "Brown",1994,11,3);
       // obj.setName("Olia");
       // obj.setSurname("Stefanyshyn");

       // String name = object.getName();
       // String surname = object.getSurname();

        Employee em = new Manager();
        GregorianCalendar born=null;
        em.setBornDate(born);

        em.setBonus();


        Product pr1 = new Product(1, "Galaxy S", 1000, "Samsung",
                new GregorianCalendar(),
                new GregorianCalendar(2019, 2, 26));
        pr1.showExpDate();

    }
}
