package com.stef.MagazineProject.mysql;

import com.stef.MagazineProject.DAO.GenericDao;
import com.stef.MagazineProject.domain.Order;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MySQLOrderDaoTest {
    @Test
    public void createInDB() throws Exception {
        Order client = new Order(1);
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Order.class);
        Order orderField = (Order) dao.createInDB(client);
        System.out.println(orderField.toString());
    }

    @Test
    public void read() throws Exception {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Order.class);
        Order findOrder = (Order) dao.read(23);
        assertNotNull(findOrder);
        System.out.println(findOrder.toString());
    }

    @Test
    public void update() throws Exception {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Order.class);
        Order order = (Order) dao.read(23);
        order.setClientId(2);
        dao.update(order);
    }

    @Test
    public void delete() throws Exception {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Order.class);
        dao.delete(1);
    }

    @Test
    public void readAll() throws Exception {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Order.class);
        ArrayList<Order> orders = dao.readAll();
        assertNotNull(orders);
    }

}