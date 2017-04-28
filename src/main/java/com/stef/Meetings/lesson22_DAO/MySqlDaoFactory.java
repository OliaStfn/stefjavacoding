package com.stef.Meetings.lesson22_DAO;

import com.stef.Meetings.lesson20_JDBC.DataBaseWork;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDaoFactory implements DaoFactory {
    private static final Logger log = Logger.getLogger(DataBaseWork.class);
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://servlab.mysql.ukraine.com.ua:3306/servlab_devolga";
    private static String USERNAME = "servlab_devolga";
    private static String PASSWORD = "942lucxf";

    public Connection getConnection()throws SQLException {
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

    public ProductDao getProductDao(Connection connection) {
        return new MySqlProductDao(connection);
    }

    //public abstract class AbstractJDBCDao<T extends Identified<PK>, PK extends Integer> implements GenericDao<T, PK>
}
