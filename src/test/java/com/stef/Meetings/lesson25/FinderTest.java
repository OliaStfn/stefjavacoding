package com.stef.Meetings.lesson25;

import org.junit.Test;

import static org.junit.Assert.*;

public class FinderTest {
    @Test
    public void min() throws Exception {
        Integer inumbers[] = {5, 6, 8, 4, 6};
        Double dnumbers[] = {1.6, 6.5, 9.6};

        Finder<Integer> iobj = new Finder<Integer>(inumbers);
        Finder<Double> dobj = new Finder<Double>(dnumbers);

        System.out.println("inumbers[] max value: "+iobj.max());
        System.out.println("inumbers[] min value: "+iobj.min());
        System.out.println("dnumbers[] max value: "+dobj.max());
        System.out.println("dnumbers[] min value: "+dobj.min());
    }

}