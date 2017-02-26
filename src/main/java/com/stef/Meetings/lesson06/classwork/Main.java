package com.stef.Meetings.lesson06.classwork;

import com.stef.MagazineProject.Human;
import com.stef.MagazineProject.Product;

public class Main {
    public static void main(String[] args) {

        int x = 10;

        //Human obj = new Product();
        Human obj = new Human();
        Human ob1;
        Human ob2;

        obj.setName("Nazar");
        ob1 = obj;
        ob2 = new Human();
        ob2 = ob1;

        System.out.println(ob1.getName());
        System.out.println(ob2.getName());



    }
}
