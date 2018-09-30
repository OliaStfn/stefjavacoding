package com.stef.Meetings.lesson12;

import org.apache.log4j.Logger;

import java.util.Random;

public class lesson12_2 {
    private static final Logger log = Logger.getLogger(lesson12_2.class);
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
                log.error("Ділення на ноль. Виняток: " + e);
                a = 0;
                counter++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Вихід за допустимі межі масиву. Виняток: " + e);
                log.error("Вихід за допустимі межі масиву. Виняток: " + e);
            }
            System.out.println("a = " + a);
            log.info("a = " + a);
        }

        System.out.println("Ділення на ноль відбулося " + counter + " разів");
        log.info("Ділення на ноль відбулося " + counter + " разів");
    }
}
