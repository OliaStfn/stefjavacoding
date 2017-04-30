package com.stef.Meetings.lesson22_DAO;

import com.stef.MagazineProject.Client;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClientDao {
    public Client create(Client client) throws SQLException;

    public Client read(int id) throws SQLException;

    public void update(Client client) throws SQLException;

    public void delete(Client client) throws SQLException;

    public ArrayList<Client> readAll() throws SQLException;

}
