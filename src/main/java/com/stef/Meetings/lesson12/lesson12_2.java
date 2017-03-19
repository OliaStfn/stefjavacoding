package com.stef.Meetings.lesson12;

import java.util.Random;

public class lesson12_2 {
    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;
        int counter = 0;
        int someArray[] = new int[150];
        Random random = new Random();

        for (int i = 0; i < 500; i++) {
            try {
                b = random.nextInt(50);
                c = random.nextInt(50);
                a = 25698 / (b / c);
                someArray[i] = a;
            } catch (ArithmeticException e) {
                System.out.println("Ділення на ноль. Виняток: " + e);
                a = 0;
                counter++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Вихід за допустимі межі масиву. Виняток: " + e);
            }
            System.out.println("a = " + a);
        }

        System.out.println("Ділення на ноль відбулося " + counter + " разів");

    }
}
