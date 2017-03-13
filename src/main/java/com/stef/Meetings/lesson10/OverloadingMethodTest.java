package com.stef.Meetings.lesson10;

import com.stef.MagazineProject.Human;

public class OverloadingMethodTest {
    public static void main(String[] args) {
        Human hm = new Human();
        hm.setName("Nazar");
        System.out.println(hm.toString());
        hm.setName();
        System.out.println(hm.toString());
    }
}
