package com.stef.Meetings.lesson23_Generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleGenTest {
    @Test
    public void getObj() throws Exception {
        SimpleGen<String, Integer> someIntegerObject = new SimpleGen<String, Integer>("20", 20);
        System.out.println(someIntegerObject.toString());
    }

}