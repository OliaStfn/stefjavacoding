package com.stef.MagazineProject.support;

import com.stef.MagazineProject.domain.Employee;
import com.stef.MagazineProject.domain.Manager;
import com.stef.MagazineProject.domain.Product;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        Employee em = new Manager();
        GregorianCalendar born = null;
        em.setBornDate(born);

        em.setBonus();


        /*Product pr1 = new Product(1, "Galaxy S", 1000, "Samsung",
                new GregorianCalendar(),
                new GregorianCalendar(2019, 2, 26));
        pr1.showExpDate();*/

    }
}
