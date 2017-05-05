package com.stef.Meetings.lesson23_Generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatusTest {
    @Test
    public void avarege() throws Exception {
        Integer[] intArray = {5, 9, 8, 67, 64, 3};
        Double[] doubleArray = {5.0, 9.2, 8.8, 67.9, 64.66, 3.3};
        String[] stringArray = {"first", "second", "third"};


        Status<Integer> intObj = new Status<Integer>(intArray);
        Status<Double> doubleObj = new Status<Double>(doubleArray);
        //Status<String> stringObj = new Status<String>(stringArray);

        System.out.println(intObj.avarege());
        System.out.println(doubleObj.avarege());

        System.out.println(intObj.sameAvarege(doubleObj));


    }

}