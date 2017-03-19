package com.stef.Meetings.lesson12;

import java.util.Scanner;

public class lesson12_1 {
    public static void main(String[] args) {
        subProgram();
        System.out.println("After exception");
    }

    static void subProgram() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input d = ");

        try {
            int d = input.nextInt();
            int a = 50 / d;
            System.out.println("Все нормально");
        } catch (ArithmeticException e) {
            System.out.println("Ділення на ноль");
            subProgram();
        }
    }
}
