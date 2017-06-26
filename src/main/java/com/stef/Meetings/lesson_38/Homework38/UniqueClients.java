package com.stef.Meetings.lesson_38.Homework38;

import com.stef.MagazineProject.DAO.DaoException;
import com.stef.MagazineProject.DAO.GenericDao;
import com.stef.MagazineProject.domain.Client;
import com.stef.MagazineProject.domain.Order;
import com.stef.MagazineProject.mysql.MySQLDaoFactory;

import java.util.ArrayList;
import java.util.HashSet;

public class UniqueClients {
    private static HashSet<Integer> clientsId = new HashSet<>();
    private static ArrayList<Client> clients = new ArrayList<>();

    public static void main(String[] args) throws DaoException {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = factory.getDao(factory.getConnection(), Order.class);
        ArrayList<Order> orders = dao.readAll();
        for (Order order : orders) {
            clientsId.add(order.getClientId());
        }
        dao = factory.getDao(factory.getConnection(), Client.class);
        for (Integer id : clientsId) {
            clients.add((Client) dao.read(id));
        }
        for (Client client : clients) {
            System.out.println(client.toString());
        }
    }
}
