package com.stef.Meetings.lesson_39;

import com.stef.MagazineProject.DAO.DaoException;
import com.stef.MagazineProject.DAO.GenericDao;
import com.stef.MagazineProject.domain.Client;
import com.stef.MagazineProject.domain.Order;
import com.stef.MagazineProject.mysql.MySQLDaoFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClientMap {
    public static void main(String[] args) {
        Map<Integer, Client> clientMap = new HashMap<>();
        ArrayList<Client> clients = new ArrayList<>();
        MySQLDaoFactory factory = new MySQLDaoFactory();
        GenericDao dao = null;
        try {
            dao = factory.getDao(factory.getConnection(), Client.class);

            clients = dao.readAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        for(Client client: clients){
            clientMap.put(client.getId(),client);
        }

        //clientMap.forEach((k,v)-> System.out.println("key = "+ k +" value = "+v.toString()));

        //System.out.println(clientMap);
        //System.out.println(clientMap.get(2));

        for (Map.Entry<Integer,Client> entry: clientMap.entrySet()){
            Integer key = entry.getKey();
            Client value = entry.getValue();
            System.out.println("key = "+ key +" value = "+value.toString());
        }

    }
}
