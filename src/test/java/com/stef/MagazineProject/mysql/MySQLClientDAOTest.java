package com.stef.MagazineProject.mysql;

import com.stef.MagazineProject.dao.GenericDao;
import com.stef.MagazineProject.domain.Client;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by Олюнь on 21.05.2017.
 */
public class MySQLClientDAOTest {
    @Test
    public void createInDB() throws Exception {
        Client pclient = new Client("Olga", "Stefanyshyn", 1999, 03, 22,
                "0932202176", "Vovchynetska 198b/144");
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Client.class);
        Client fieldclient = (Client) dao.createInDB(pclient);
        System.out.println(fieldclient.toString());
    }

    @Test
    public void read() throws Exception {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Client.class);
        Client findclient = (Client) dao.read(1);
        assertNotNull(findclient);
        System.out.println(findclient.toString());
    }

    @Test
    public void update() throws Exception {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Client.class);
        Client client = (Client) dao.read(1);
        client.setName("Olya");
        dao.update(client);
    }

    @Test
    public void delete() throws Exception {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Client.class);
        dao.delete(2);
    }

    @Test
    public void readAll() throws Exception {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Client.class);
        ArrayList<Client> clients = dao.readAll();
        assertNotNull(clients);
    }
}