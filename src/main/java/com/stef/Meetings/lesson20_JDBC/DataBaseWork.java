package com.stef.Meetings.lesson20_JDBC;

import org.apache.log4j.Logger;

import java.sql.*;

public class DataBaseWork {
    private static final Logger log = Logger.getLogger(DataBaseWork.class);
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://servlab.mysql.ukraine.com.ua:3306/servlab_devolga";
    private static String USERNAME = "servlab_devolga";
    private static String PASSWORD = "942lucxf";


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

}
