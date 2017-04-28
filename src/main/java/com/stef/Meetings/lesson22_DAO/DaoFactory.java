package com.stef.Meetings.lesson22_DAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {
    public Connection getConnection() throws SQLException;
    public ProductDao getProductDao(Connection connection);
}
