package com.stef.Meetings.lesson_36.Homework36;

import com.stef.Meetings.lesson36_1.LinkedListStack;
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