package com.stef.MagazineProject.mysql;

import com.stef.MagazineProject.dao.GenericDao;
import com.stef.MagazineProject.domain.Product;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class MysqlProductDaoTest {
    @Test
    public void createInDB() throws Exception {
        Product product = new Product("salat Caesar", 30.0, "pizza+", new GregorianCalendar(),
                new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DATE + 1));
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Product.class);
        Product fieldproduct = (Product) dao.createInDB(product);
        System.out.println(fieldproduct.toString());
    }

    @Test
    public void read() throws Exception {
        MySQLDaoFactory factory=new MySQLDaoFactory();
        GenericDao dao=factory.getDao(factory.getConnection(),Product.class);
        Product findproduct=(Product) dao.read(5);
        assertNotNull(findproduct);
        System.out.println(findproduct.toString());
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void readAll() throws Exception {
    }

}