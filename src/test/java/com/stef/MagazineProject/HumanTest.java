package com.stef.MagazineProject;

import org.junit.Test;

import static org.junit.Assert.*;

public class HumanTest {
    @Test
    public void getAge() throws Exception {
        Human hm = new Human("Olia","Stefanyshyn",1999,3,22);
        assertEquals(17,hm.getAge(),0);
    }

}