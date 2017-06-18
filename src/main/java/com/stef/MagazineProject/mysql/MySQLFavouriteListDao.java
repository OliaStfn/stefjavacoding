package com.stef.MagazineProject.mysql;

import com.stef.MagazineProject.DAO.AbstractDao;
import com.stef.MagazineProject.DAO.DaoException;
import com.stef.MagazineProject.DAO.GenericDao;
import com.stef.MagazineProject.domain.FavouriteList;
import com.stef.MagazineProject.domain.Goods;
import org.apache.commons.lang.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MySQLFavouriteListDao extends AbstractDao<FavouriteList,Integer> {

    public MySQLFavouriteListDao(Connection connection) {
        super(connection);
    }

    private class GoodsForDB extends Goods {
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM favourite_lists WHERE favourite_list_id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT f.*,g.* FROM favourite_lists f " +
                "NATURAL JOIN goods g" +
                "NATURAL JOIN favourite_list_goods fg" +
                "WHERE f.favourite_list_id=fg.favourite_list_id" +
                "AND g.goods_id=fg.goods_id;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO favourite_lists(client_id) VALUES(?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE favourite_lists SET client_id=? WHERE favourite_list_id=?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM favourite_lists WHERE favourite_list_id=?";
    }

    @Override
    public ArrayList<FavouriteList> parseResultSet(ResultSet resultSet) throws DaoException {
        ArrayList<FavouriteList> lists = new ArrayList<FavouriteList>();
        try {
            while (resultSet.next()) {
                FavouriteList favouriteList = new FavouriteList();
                GoodsForDB item = new GoodsForDB();
                favouriteList.setId(resultSet.getInt("favourite_list_id"));
                favouriteList.setClientId(resultSet.getInt("client_id"));
                item.setId(resultSet.getInt("goods_id"));
                item.setName(resultSet.getString("goods_name"));
                item.setPrice(resultSet.getDouble("goods_price"));
                item.setVendor(resultSet.getString("goods_vendor"));
                item.setProductionDate(convertToGD(resultSet.getDate("goods_production_date")));
                item.setExpDate(convertToGD(resultSet.getDate("goods_expiration_date")));
                if (favouriteList.getId()==lists.get(lists.size()-1).getId()){
                    lists.get(lists.size()-1).addProduct(item);
                }
                else {
                    favouriteList.addProduct();
                    lists.add(favouriteList);
                }
                lists.add(favouriteList);
            }
        } catch (Exception e) {
            throw new DaoException(e+"error with pars result set");
        }
        return lists;
    }

    @Override
    public void statementUpdate(PreparedStatement statement, FavouriteList obj) throws DaoException {
        try {
            statement.setInt(1, obj.getClientId());
            statement.setInt(2, obj.getId());
        } catch (SQLException e) {
            throw new DaoException(e+"error with statement update");
        }
    }

    @Override
    public void statementInsert(PreparedStatement statement, FavouriteList obj) throws DaoException {
        try {
            statement.setInt(1, obj.getClientId());
        } catch (SQLException e) {
            throw new DaoException(e+"error with statement insert");
        }
    }

    @Override
    public FavouriteList create() throws DaoException {
        throw new NotImplementedException();
    }
}