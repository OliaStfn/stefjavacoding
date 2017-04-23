package com.stef.Meetings.lesson20_JDBC;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataBaseWorkTest {
    @Test
    public void getProducts() throws Exception {
        DataBaseWork.getProducts();
    }

    @Test
    public void updateProduct() throws Exception {
        DataBaseWork.updateProduct();
    }

    @Test
    public void addNewProduct() throws Exception {
        DataBaseWork.addNewProduct();
    }

    @Test
    public void connectionTest() throws Exception {
        assertNotNull(DataBaseWork.getConnection());
    }

}