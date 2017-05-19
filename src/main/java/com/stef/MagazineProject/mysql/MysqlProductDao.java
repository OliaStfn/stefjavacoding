package com.stef.MagazineProject.mysql;

import com.stef.MagazineProject.dao.AbstractDao;
import com.stef.MagazineProject.dao.DaoException;
import com.stef.MagazineProject.domain.Product;

import java.sql.*;
import java.util.ArrayList;

public class MysqlProductDao extends AbstractDao<Product, Integer> {

    public MysqlProductDao(Connection connection) {
        super(connection);
    }

    private class ProductForDB extends Product{
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM goods";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO goods(name,price,vendor,productionDate,expdate) VALUES(?,?,?,?,?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE goods SET name=?,price=?,vendor=?,productionDate=?,expdate=? WHERE id=?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM goods WHERE id=?";
    }

    @Override
    public ArrayList<Product> parseResultSet(ResultSet resultSet) throws DaoException {
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            while (resultSet.next()) {
                ProductForDB item = new ProductForDB();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));
                item.setVendor(resultSet.getString("vendor"));
                products.add(item);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return products;
    }

    @Override
    public void statementUpdate(PreparedStatement statement, Product obj) throws DaoException {
        try {
            statement.setString(1,obj.getName());
            statement.setDouble(2,obj.getPrice());
            statement.setString(3,obj.getVendor());
            statement.setDate(4, Date.valueOf("2017-04-28"));
            statement.setDate(5, Date.valueOf("2017-04-30"));
            statement.setInt(6,obj.getId());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void statementInsert(PreparedStatement statement, Product obj) throws DaoException {
        try {
            statement.setString(1,obj.getName());
            statement.setDouble(2,obj.getPrice());
            statement.setString(3,obj.getVendor());
            statement.setDate(4, Date.valueOf("2017-04-28"));
            statement.setDate(5, Date.valueOf("2017-04-30"));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Product create() throws DaoException {
        Product tempProduct = new Product();
        return createInDB(tempProduct);
    }
}
