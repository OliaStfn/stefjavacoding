package com.stef.MagazineProject.mysql;

import com.stef.MagazineProject.DAO.GenericDao;
import com.stef.MagazineProject.domain.Goods;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class MySQLProductDaoTest {
    @Test
    public void createInDB() throws Exception {
        Goods goods = new Goods("salat Caesar", 30.0, "pizza+", new GregorianCalendar(),
                new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, Calendar.DATE + 1));
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Goods.class);
        Goods fieldproduct = (Goods) dao.createInDB(goods);
        System.out.println(fieldproduct.toString());
    }

    @Test
    public void read() throws Exception {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Goods.class);
        Goods findproduct = (Goods) dao.read(5);
        assertNotNull(findproduct);
        System.out.println(findproduct.toString());
    }

    @Test
    public void update() throws Exception {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Goods.class);
        Goods goods = (Goods) dao.read(5);
        goods.setPrice(8);
        dao.update(goods);
    }

    @Test
    public void delete() throws Exception {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Goods.class);
        Goods findproduct = (Goods) dao.read(17);
        dao.delete(findproduct);
    }

    @Test
    public void readAll() throws Exception {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Goods.class);
        ArrayList<Goods> goodss = dao.readAll();
        assertNotNull(goodss);
    }

}