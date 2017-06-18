package com.stef.Meetings.lesson_33.Homework36;

import org.junit.Test;

public class LinkedListStackTest {
    @Test
    public void pop() throws Exception {

        LinkedListStack<Double> number = new LinkedListStack<Double>();
        number.push(5.3);
        number.push(8.7);
        number.push(1.1);

        while (!number.isEmpty()) {
            System.out.println(number.pop());
        }
    }
}