package com.stef.Meetings.lesson33;

import com.stef.MagazineProject.domain.Client;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class IterExample {
    public static void main(String[] args) {
        Collection<Client> clients = new LinkedList<Client>();
        Iterator<Client> iterator = clients.iterator();


        for (Client client : clients) {
            client.toString();

        }

        while (iterator.hasNext()) {

            Client temp = iterator.next();
            System.out.println(temp.toString());
            iterator.remove();
            iterator.next();
            iterator.remove();

        }
    }
}
