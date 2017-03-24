package com.stef.Meetings.lesson12;

public class lesson12_3 {
    public static void main(String[] args) {

        try {
            demo();
        } catch (Exception e) {
            System.out.println("Повторний перехват : " + e);
        }

    }

    static void demo() throws ArithmeticException{

            throw new ArithmeticException("Демонстрація");
    }
}
