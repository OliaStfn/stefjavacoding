package com.stef.MagazineProject.mysql;

import com.stef.MagazineProject.dao.AbstractDao;
import com.stef.MagazineProject.dao.DaoException;
import com.stef.MagazineProject.domain.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MySQLClientDAO extends AbstractDao<Client, Integer> {

    public MySQLClientDAO(Connection connection) {
        super(connection);
    }

    private class ClientForDB extends Client {
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM client";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO client(name,surname,born_date,phone_number,address) VALUES(?,?,?,?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE client SET name=?,surname=?,born_date=?,phone_number=?,address=? WHERE id=?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM client WHERE id=?";
    }

    @Override
    public ArrayList<Client> parseResultSet(ResultSet resultSet) throws DaoException {
        ArrayList<Client> clients = new ArrayList<Client>();
        try {
            while (resultSet.next()) {
                MySQLClientDAO.ClientForDB client = new MySQLClientDAO.ClientForDB();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setSurname(resultSet.getString("surname"));
                client.setBornDate(convertToGD(resultSet.getDate("born_date")));
                client.setPhoneNumber(resultSet.getString("phone_number"));
                client.setAddress(resultSet.getString("address"));
                clients.add(client);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return clients;
    }

    @Override
    public void statementUpdate(PreparedStatement statement, Client obj) throws DaoException {
        try {
            statement.setString(1, obj.getName());
            statement.setString(2, obj.getSurname());
            statement.setDate(3,convertToDate(obj.getBornDate()));
            statement.setString(4,obj.getPhoneNumber());
            statement.setString(5,obj.getAddress());
            statement.setInt(6, obj.getId());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void statementInsert(PreparedStatement statement, Client obj) throws DaoException {
        try {
            statement.setString(1, obj.getName());
            statement.setString(2, obj.getSurname());
            statement.setDate(3,convertToDate(obj.getBornDate()));
            statement.setString(4,obj.getPhoneNumber());
            statement.setString(5,obj.getAddress());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Client create() throws DaoException {
        Client tempClient = new Client();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name: ");
        tempClient.setName(in.nextLine());
        System.out.println("Enter surname: ");
        tempClient.setSurname(in.nextLine());
        System.out.println("Enter year of birth: ");
        int year = in.nextInt();
        System.out.println("Enter month of birth: ");
        int month = in.nextInt();
        System.out.println("Enter day of birth: ");
        int day = in.nextInt();
        tempClient.setBornDate(new GregorianCalendar(year, month, day));
        System.out.println("Enter phone number: ");
        tempClient.setPhoneNumber(in.nextLine());
        System.out.println("Enter address: ");
        tempClient.setAddress(in.nextLine());
        return createInDB(tempClient);
    }

}
