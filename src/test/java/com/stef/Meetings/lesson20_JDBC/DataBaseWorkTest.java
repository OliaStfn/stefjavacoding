package com.stef.Meetings.lesson20_JDBC;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataBaseWorkTest {

    @Test
    public void connectionTest() throws Exception{
        assertNotNull(DataBaseWork.getConnection());
    }

}