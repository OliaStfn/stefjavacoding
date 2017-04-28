package com.stef.Meetings.lesson20_JDBC;

import com.stef.MagazineProject.Product;
import org.apache.log4j.Logger;

import java.sql.*;

public class DataBaseWork {
    private static final Logger log = Logger.getLogger(DataBaseWork.class);
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://servlab.mysql.ukraine.com.ua:3306/servlab_devolga";
    private static String USERNAME = "servlab_devolga";
    private static String PASSWORD = "942lucxf";


    private static final String INSERT_NEW = "INSERT INTO goods"
            + "(ID,NAME,PRICE,VENDOR,PRODUCTIONDATE,EXPDATE)"
            + " VALUES (?, ?, ?, ?, ?, ?)";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(driverName); // Завантажуємо клас драйвера
            log.info("We get driver JDBC");
        } catch (ClassNotFoundException e) {
            log.error("Driver JDBC has NOT get");
            log.error(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("The successful connection for DB");
        } catch (SQLException e) {
            log.error("Failed connection for DB");
            log.error(e.getMessage());
        }
        return connection;
    }


    public static void updateProduct() throws SQLException {
        Connection con = null;
        Statement stm = null;

        String sql_query = "UPDATE goods SET price=27 WHERE name='burger'";

        try {
            con = getConnection();
            stm = con.createStatement();
            stm.executeUpdate(sql_query);
            log.info("Product was updated successfully");
        } catch (SQLException e) {
            log.error("Product wasn't updated");
            log.error(e.getMessage());
        } finally {
            if (con != null) con.close();
            if (stm != null) stm.close();
        }

    }


    public static void getProducts() throws SQLException {
        Connection con = null;
        Statement stm = null;

        String sql_query = "SELECT * FROM goods";

        try {
            con = getConnection();
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql_query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String vendor = rs.getString("vendor");
                Date prDate = rs.getDate("productionDate");
                Date expDate = rs.getDate("expDate");

                System.out.println(id + "\t" + name + "\t" + price + "\t" + vendor + "\t" + prDate + "\t" + expDate);
            }
        } catch (SQLException e) {
            log.error("Error in getting products from DB");
            log.error(e.getMessage());
        } finally {
            if (con != null) con.close();
            if (stm != null) stm.close();
        }


    }

    public static void deleteProduct() throws SQLException {
        Connection con = null;
        Statement stm = null;

        String sql_query = "DELETE FROM goods WHERE id=2;";

        try {
            con = getConnection();
            stm = con.createStatement();
            stm.executeUpdate(sql_query);
            log.info("Product was deleted successfully");
        } catch (SQLException e) {
            log.error("Product wasn't delete");
            log.error(e.getMessage());
        } finally {
            if (con != null) con.close();
            if (stm != null) stm.close();
        }

    }

    public static void createProduct() throws SQLException {
        Connection con = null;
        Statement stm = null;

        String sql_query = "INSERT INTO goods" +
                "(id,name,price,vendor,productionDate,expdate)" +
                "VALUES (7,'HotDog',25,'Chicken hut','2017-04-28','2017-04-30')";

        try {
            con = getConnection();
            stm = con.createStatement();
            stm.executeUpdate(sql_query);
            log.info("Product was created successfully");
        } catch (SQLException e) {
            log.error("Product wasn't create");
            log.error(e.getMessage());
        } finally {
            if (con != null) con.close();
            if (stm != null) stm.close();
        }

    }


    public static void addNewProduct() throws SQLException {
        Connection con = null;
        Statement stm = null;

        /*String sql_query = "INSERT INTO goods"
                + "(ID,NAME,PRICE,VENDOR,PRODUCTIONDATE,EXPDATE)"
                + " VALUES (6, 'burger', 40.50, 'RoyalBurger', '2017-4-23', '2017-4-27')";*/

        try {
            con = getConnection();
            stm = con.createStatement();

            stm.addBatch("INSERT INTO goods"
                    + "(ID,NAME,PRICE,VENDOR,PRODUCTIONDATE,EXPDATE)"
                    + " VALUES (7, 'burger', 40.50, 'RoyalBurger', '2017-4-23', '2017-4-27')");

            stm.addBatch("INSERT INTO goods"
                    + "(ID,NAME,PRICE,VENDOR,PRODUCTIONDATE,EXPDATE)"
                    + " VALUES (8, 'burger', 40.50, 'RoyalBurger', '2017-4-23', '2017-4-27')");

            stm.executeBatch();
            stm.clearBatch();
            log.info("Product was added successfully");
        } catch (SQLException e) {
            log.error("Product wasn't added");
            log.error(e.getMessage());
        } finally {
            if (con != null) con.close();
            if (stm != null) stm.close();
        }
    }

    public static void addNewProductPS() throws SQLException {
        Connection con = null;
        PreparedStatement prst = null;

        try {
            con = getConnection();
            prst = con.prepareStatement(INSERT_NEW);

            prst.setInt(1, 9);
            prst.setString(2,"mohito");
            prst.setDouble(3,30.0);
            prst.setString(4,"pizza+");
            prst.setDate(5, java.sql.Date.valueOf("2017-04-28"));
            prst.setDate(6,java.sql.Date.valueOf("2017-04-30"));
            prst.execute();

            log.info("Product was added successfully");
        } catch (SQLException e) {
            log.error("Product wasn't added");
            log.error(e.getMessage());
        } finally {
            if (con != null) con.close();
            if (prst != null) prst.close();
        }
    }

}
