package com.stef.MagazineProject.mysql;

import com.stef.MagazineProject.DAO.AbstractDao;
import com.stef.MagazineProject.DAO.DaoException;
import com.stef.MagazineProject.DAO.GenericDao;
import com.stef.MagazineProject.domain.FavouriteList;
import com.stef.MagazineProject.domain.FavouriteListLine;
import com.stef.MagazineProject.domain.Goods;
import org.apache.commons.lang.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MySQLFavouriteListDao extends AbstractDao<FavouriteList, Integer> {

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
        return "SELECT * FROM favourite_lists F" +
                " JOIN favourite_list_goods FG USING (favourite_list_id)" +
                " JOIN goods G USING (goods_id) WHERE favourite_list_id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM favourite_lists F" +
                " JOIN favourite_list_goods FG USING (favourite_list_id)" +
                " JOIN goods G USING (goods_id);";
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
        boolean temp = false;

        try {
            while (resultSet.next()) {
                FavouriteList favouriteList = new FavouriteList();
                FavouriteListLine line=new FavouriteListLine();
                GoodsForDB item = new GoodsForDB();
                item.setId(resultSet.getInt("goods_id"));
                item.setName(resultSet.getString("goods_name"));
                item.setPrice(resultSet.getDouble("goods_price"));
                item.setVendor(resultSet.getString("goods_vendor"));
                item.setProductionDate(convertToGD(resultSet.getDate("goods_production_date")));
                item.setExpDate(convertToGD(resultSet.getDate("goods_expiration_date")));
                line.setId(resultSet.getInt("line_id"));
                line.setFavoriteListId(resultSet.getInt("favourite_list_id"));
                line.setGoods(item);
                favouriteList.setId(resultSet.getInt("favourite_list_id"));
                favouriteList.setClientId(resultSet.getInt("client_id"));
                for (FavouriteList favouriteList1: lists) {
                    if (favouriteList1.getId() == favouriteList.getId()) {
                        favouriteList1.addNewLine(line);
                        temp = true;
                    }
                }
                if(!temp){
                    favouriteList.addNewLine(line);
                    lists.add(favouriteList);
                }
            }
        } catch (Exception e) {
            throw new DaoException(e + "error with pars result set");
        }
        return lists;
    }

    @Override
    public void statementUpdate(PreparedStatement statement, FavouriteList obj) throws DaoException {
        try {
            statement.setInt(1, obj.getClientId());
            statement.setInt(2, obj.getId());
        } catch (SQLException e) {
            throw new DaoException(e + "error with statement update");
        }
    }

    @Override
    public void statementInsert(PreparedStatement statement, FavouriteList obj) throws DaoException {
        try {
            statement.setInt(1, obj.getClientId());
        } catch (SQLException e) {
            throw new DaoException(e + "error with statement insert");
        }
    }

    @Override
    public FavouriteList create() throws DaoException {
        throw new NotImplementedException();
    }
}