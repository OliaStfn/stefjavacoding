package com.stef.Meetings.lesson23_Generics;

public class Status<P extends Number> {
    P[] numbers;

    public Status(P[] numbers) {
        this.numbers = numbers;
    }

    public double avarege() {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i].doubleValue();
        }
        return sum / numbers.length;
    }
}
