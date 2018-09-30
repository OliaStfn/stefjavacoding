package com.stef.MagazineProject.mysql;

import com.stef.MagazineProject.DAO.DaoException;
import com.stef.MagazineProject.DAO.GenericDao;
import com.stef.MagazineProject.domain.Client;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MySQLClientDAOTest {
    @Test
    public void createInDB() throws DaoException {
        Client client = new Client("Nazar", "Mykhailiv", 1990, 30, 7,
                "0632202176", "Vovchynetska 198b/144");
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Client.class);
        Client fieldclient = (Client) dao.createInDB(client);
        System.out.println(fieldclient.toString());
    }

    @Test
    public void read() throws DaoException {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Client.class);
        Client findclient = (Client) dao.read(1);
        assertNotNull(findclient);
        System.out.println(findclient.toString());
    }

    @Test
    public void update() throws DaoException {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Client.class);
        Client client = (Client) dao.read(1);
        client.setName("Olya");
        dao.update(client);
    }

    @Test
    public void delete() throws DaoException {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Client.class);
        //dao.delete(3);
    }

    @Test
    public void readAll() throws DaoException {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Client.class);
        ArrayList<Client> clients = dao.readAll();
        assertNotNull(clients);
    }
}