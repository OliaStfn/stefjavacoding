package com.stef.Meetings.lesson37;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class ArrayQueueTest {
    @Test
    public void add() throws Exception {
        ArrayQueue<Integer> array = new ArrayQueue<Integer>(10);
        array.add(5);
        array.add(5283);
        array.add(1);
        while (!array.isEmpty()){
            System.out.println(array.remove());
        }
    }

}