package com.stef.Meetings.lesson22_DAO;

import com.stef.MagazineProject.domain.Client;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MySqlDaoClient implements ClientDao {
    private static final Logger log = Logger.getLogger(MySqlDaoClient.class);
    private Connection connection;

    private static final String INSERT_NEW = "INSERT INTO client"
            + "(id,Name,Surname,BornDate,PhoneNumber,Address)"
            + " VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_NEW = "SELECT * FROM client WHERE id=?";

    private static final String UPDATE_NEW = "UPDATE client SET Name=?,Surname=?,BornDate=?,PhoneNumber=?,Address=? " +
            "WHERE id=? ";

    private static final String DELETE_NEW = "DELETE FROM client WHERE id=?;";

    private static final String SELECT_ALL_NEW = "SELECT * FROM client";

    public MySqlDaoClient(Connection connection) {
        this.connection = connection;
    }


    public Client create(Client client) throws SQLException {
        PreparedStatement prst = null;

        try {
            prst = connection.prepareStatement(INSERT_NEW);
            prst.setInt(1, client.getId());
            prst.setString(2, client.getName());
            prst.setString(3, client.getSurname());
            prst.setDate(4, java.sql.Date.valueOf("1970-04-30"));
            prst.setString(5, client.getPhoneNumber());
            prst.setString(6, client.getAddress());
            prst.execute();

            log.info("Client was created successfully");
        } catch (SQLException e) {
            log.error("Client wasn't create");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prst != null) prst.close();
        }
        return client;
    }


    public Client read(int id) throws SQLException {
        PreparedStatement prst = null;
        Client client = null;

        try {
            prst = connection.prepareStatement(SELECT_NEW);
            prst.setInt(1, id);
            ResultSet rs = prst.executeQuery();
            Calendar cal = Calendar.getInstance();
            GregorianCalendar tempDate;

            while (rs.next()) {
                int ID = rs.getInt("id");
                String Name = rs.getString("name");
                String Surname = rs.getString("Surname");
                Date BornDate = rs.getDate("BornDate");
                cal.setTime(BornDate);
                tempDate = (GregorianCalendar) cal;
                String PhoneNumber = rs.getString("PhoneNumber");
                String Address = rs.getString("Address");
                client = new Client(ID, Name, Surname, tempDate, PhoneNumber, Address);
            }
        } catch (SQLException e) {
            log.error("Error in getting clients from DB");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prst != null) prst.close();
        }
        return client;
    }


    public void update(Client client) throws SQLException {
        PreparedStatement prst = null;

        try {
            prst = connection.prepareStatement(UPDATE_NEW);

            prst.setString(1, client.getName());
            prst.setString(2, client.getSurname());
            prst.setDate(3, java.sql.Date.valueOf("1970-04-30"));
            prst.setString(4, client.getPhoneNumber());
            prst.setString(5, client.getAddress());
            prst.setInt(6, client.getId());
            prst.executeUpdate();
            log.info("Client was updated successfully");
        } catch (SQLException e) {
            log.error("Client wasn't updated");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prst != null) prst.close();
        }
    }


    public void delete(Client client) throws SQLException {
        PreparedStatement prst = null;

        try {

            prst = connection.prepareStatement(DELETE_NEW);
            prst.setInt(1, client.getId());
            prst.executeUpdate();
            log.info("Client was deleted successfully");
        } catch (SQLException e) {
            log.error("Client wasn't delete");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prst != null) prst.close();
        }
    }


    public ArrayList<Client> readAll() throws SQLException {
        PreparedStatement prst = null;
        ArrayList<Client> clients = new ArrayList<Client>();
        Calendar cal = Calendar.getInstance();
        GregorianCalendar tempDate;

        try {

            prst = connection.prepareStatement(SELECT_ALL_NEW);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                String Name = rs.getString("name");
                String Surname = rs.getString("Surname");
                Date BornDate = rs.getDate("BornDate");
                cal.setTime(BornDate);
                tempDate = (GregorianCalendar) cal;
                String PhoneNumber = rs.getString("PhoneNumber");
                String Address = rs.getString("Address");
                clients.add(new Client(ID, Name, Surname, tempDate, PhoneNumber, Address));
            }
        } catch (SQLException e) {
            log.error("Error in getting clients from DB");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prst != null) prst.close();
        }
        return clients;
    }
}
