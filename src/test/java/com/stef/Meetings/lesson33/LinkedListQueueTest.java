package com.stef.Meetings.lesson33;

import com.stef.MagazineProject.domain.Client;
import org.junit.Test;

public class LinkedListQueueTest {
    @Test
    public void add() throws Exception {
        LinkedListQueue<Client> clientQueue=new LinkedListQueue<Client>();
        clientQueue.add(new Client());
        clientQueue.add(new Client());
        clientQueue.add(new Client());

        while (!clientQueue.isEmpty()){
            System.out.println(clientQueue.remove().toString());
            System.out.println("Queue of clients now: "+clientQueue.size()+"\n");
        }
    }

}