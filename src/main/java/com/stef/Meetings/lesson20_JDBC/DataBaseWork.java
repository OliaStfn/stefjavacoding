package com.stef.Meetings.lesson20_JDBC;

import java.sql.*;

public class DataBaseWork {
    private static String diverName = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://servlab.mysql.ukraine.com.ua:3306/servlab_devolga";
    private static String USERNAME = "servlab_devolga";
    private static String PASSWORD = "942lucxf";


    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(diverName); // Завантажуємо клас драйвера

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
