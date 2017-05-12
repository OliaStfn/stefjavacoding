package com.stef.MagazineProject.mysql;

import com.stef.MagazineProject.dao.AbstractDao;
import com.stef.MagazineProject.dao.DaoException;
import com.stef.MagazineProject.domain.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MysqlProductDao extends AbstractDao<Product, Integer> {

    public MysqlProductDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM goods";
    }

    @Override
    public ArrayList<Product> parseResultSet(ResultSet resultSet) throws DaoException {
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            while (resultSet.next()) {
                Product item = new Product();
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
}
