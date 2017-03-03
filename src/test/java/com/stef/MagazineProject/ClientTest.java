package com.stef.MagazineProject;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {
    @Test
    public void getsTest() throws Exception {
        String name = "Nazar";
        String surname = "Mykhailiv";
        int year = 1990, month = 7, day = 30;
        String phoneNumber = "0971073443";
        String address = "Bohorodchany";

        Client cl = new Client(name, surname, year, month, day, phoneNumber, address);
        //Client cl = new Client();

        assertEquals(name, cl.getName());
        assertEquals(surname, cl.getSurname());
        assertEquals(phoneNumber, cl.getPhoneNumber());
    }
}