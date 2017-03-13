package com.stef.MagazineProject;

import org.junit.Test;

import static org.junit.Assert.*;

public class HumanTest {
    @Test
    public void setName() throws Exception {
        Human hm = new Human();
        hm.setName("Nazar");
        hm.toString();
        hm.setName();
        hm.toString();
    }

    @Test
    public void getAge() throws Exception {
        Human hm2 = new Human();
        Human hm = new Human("Olia", "Stefanyshyn", 1999, 3, 22);
        assertEquals(17, hm.getAge(), 0);
    }

}