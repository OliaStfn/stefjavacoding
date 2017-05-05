package com.stef.Meetings.lesson22_DAO;

import com.stef.MagazineProject.Product;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MySqlDaoProduct implements ProductDao {
    private static final Logger log = Logger.getLogger(MySqlDaoProduct.class);
    private Connection connection;

    private static final String INSERT_NEW = "INSERT INTO goods"
            + "(ID,NAME,PRICE,VENDOR,PRODUCTIONDATE,EXPDATE)"
            + " VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_NEW = "SELECT * FROM goods WHERE id=?";

    private static final String UPDATE_NEW = "UPDATE goods SET name=?,price=?,vendor=?,productionDate=?,expdate=? " +
            "WHERE id=? ";

    private static final String DELETE_NEW = "DELETE FROM goods WHERE id=?;";

    private static final String SELECT_ALL_NEW = "SELECT * FROM goods";

    public MySqlDaoProduct(Connection connection) {
        this.connection = connection;
    }


    public Product create(Product product) throws SQLException {
        PreparedStatement prst = null;

        try {
            prst = connection.prepareStatement(INSERT_NEW);
            prst.setInt(1, product.getId());
            prst.setString(2, product.getName());
            prst.setDouble(3, product.getPrice());
            prst.setString(4, product.getVendor());
            prst.setDate(5, java.sql.Date.valueOf("2017-04-30"));
            prst.setDate(6, java.sql.Date.valueOf("2017-05-20"));
            prst.execute();

            log.info("Product was created successfully");
        } catch (SQLException e) {
            log.error("Product wasn't create");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prst != null) prst.close();
        }
        return product;
    }


    public Product read(int id) throws SQLException {
        PreparedStatement prst = null;
        Product product = null;
        Calendar cal = Calendar.getInstance();
        GregorianCalendar tempDate;
        GregorianCalendar tempDate2;

        try {
            prst = connection.prepareStatement(SELECT_NEW);
            prst.setInt(1, id);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String vendor = rs.getString("vendor");
                Date prDate = rs.getDate("productionDate");
                cal.setTime(prDate);
                tempDate = (GregorianCalendar) cal;
                Date expDate = rs.getDate("expDate");
                cal.setTime(prDate);
                tempDate2 = (GregorianCalendar) cal;
                product = new Product(ID, name, price, vendor, tempDate, tempDate2);
            }
        } catch (SQLException e) {
            log.error("Error in getting products from DB");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prst != null) prst.close();
        }
        return product;
    }


    public void update(Product product) throws SQLException {
        PreparedStatement prst = null;

        try {
            prst = connection.prepareStatement(UPDATE_NEW);
            prst.setString(1, product.getName());
            prst.setDouble(2, product.getPrice());
            prst.setString(3, product.getVendor());
            prst.setDate(4, java.sql.Date.valueOf("2017-04-30"));
            prst.setDate(5, java.sql.Date.valueOf("2017-06-02"));
            prst.setInt(6, product.getId());
            prst.executeUpdate();
            log.info("Product was updated successfully");
        } catch (SQLException e) {
            log.error("Product wasn't updated");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prst != null) prst.close();
        }
    }


    public void delete(Product product) throws SQLException {
        PreparedStatement prst = null;

        try {
            prst = connection.prepareStatement(DELETE_NEW);
            prst.setInt(1, product.getId());
            prst.executeUpdate();
            log.info("Product was deleted successfully");
        } catch (SQLException e) {
            log.error("Product wasn't delete");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prst != null) prst.close();
        }
    }


    public ArrayList<Product> readAll() throws SQLException {
        PreparedStatement prst = null;
        ArrayList<Product> products = new ArrayList<Product>();
        Calendar cal = Calendar.getInstance();
        GregorianCalendar tempDate;
        GregorianCalendar tempDate2;

        try {

            prst = connection.prepareStatement(SELECT_ALL_NEW);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String vendor = rs.getString("vendor");
                Date prDate = rs.getDate("productionDate");
                cal.setTime(prDate);
                tempDate = (GregorianCalendar) cal;
                Date expDate = rs.getDate("expDate");
                cal.setTime(prDate);
                tempDate2 = (GregorianCalendar) cal;

                products.add(new Product(ID, name, price, vendor, tempDate, tempDate2));

            }
        } catch (SQLException e) {
            log.error("Error in getting products from DB");
            log.error(e.getMessage());
        } finally {
            if (connection != null) connection.close();
            if (prst != null) prst.close();
        }
        return products;
    }

}
