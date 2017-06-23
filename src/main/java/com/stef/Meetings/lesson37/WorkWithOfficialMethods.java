package com.stef.Meetings.lesson37;

import java.util.ArrayList;
import java.util.LinkedList;

public class WorkWithOfficialMethods {

    public static void main(String[] args) {
        ArrayList<Integer> number = new ArrayList<Integer>();
        LinkedList<Double> num = new LinkedList<Double>();

        number.add(1);
        number.add(8);
        number.add(56);
        number.add(78);

        System.out.println(number + "\n");

        num.add(4.5);
        num.add(7.1);
        num.add(0.5);
        num.add(45.9);

        System.out.println(num + "\n");

        System.out.println("Contains 8: " + number.contains(8));
        System.out.println("Remove 1: " + num.remove(1));
        System.out.println("Is empty? " + number.isEmpty());
        System.out.println("Remove last: " + num.removeLast());
        System.out.println("Size: " + number.size());
        System.out.println("HashCode: " + num.hashCode());
    }
}
