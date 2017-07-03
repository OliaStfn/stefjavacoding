package com.stef.MagazineProject.mysql;

import com.stef.MagazineProject.DAO.AbstractDao;
import com.stef.MagazineProject.DAO.DaoException;
import com.stef.MagazineProject.domain.Goods;
import com.stef.MagazineProject.domain.Order;
import com.stef.MagazineProject.domain.OrderLine;
import org.apache.commons.lang.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLOrderDao extends AbstractDao<Order, Integer> {

    public MySQLOrderDao(Connection connection) {
        super(connection);
    }

    private class GoodsForDB extends Goods {
        public void setId(int id) {
            super.setId(id);
        }
    }


    @Override
    public String getSelectQuery() {
        return "SELECT * FROM orders O JOIN orders_goods OG USING (order_id)\n" +
                "JOIN goods G ON (goods_id=OG.good_id) " +
                "JOIN order_status OS USING (order_id) " +
                "JOIN status S USING (status_id) WHERE order_id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM orders O JOIN orders_goods OG USING (order_id)\n" +
                "JOIN goods G ON (goods_id=OG.good_id) " +
                "JOIN order_status OS USING (order_id) " +
                "JOIN status S USING (status_id);";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO orders(client_id) VALUES(?);";
    }

    @Override
    public String getUpdateQuery() {
        return "INSERT INTO order_status (order_id,status_id,order_status_date) " +
                "VALUES(?,(SELECT status_id FROM status WHERE status=?),NOW());";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM orders WHERE order_id=?;";
    }

    @Override
    public ArrayList<Order> parseResultSet(ResultSet resultSet) throws DaoException {
        ArrayList<Order> orders = new ArrayList<Order>();
        boolean temp = false;
        try {
            while (resultSet.next()) {
                Order order = new Order();
                OrderLine line = new OrderLine();
                GoodsForDB goods = new GoodsForDB();
                goods.setId(resultSet.getInt("goods_id"));
                goods.setName(resultSet.getString("goods_name"));
                goods.setPrice(resultSet.getDouble("goods_price"));
                goods.setVendor(resultSet.getString("goods_vendor"));
                goods.setProductionDate(convertToGD(resultSet.getDate("goods_production_date")));
                goods.setExpDate(convertToGD(resultSet.getDate("goods_expiration_date")));
                line.setGoods(goods);
                line.setCount(resultSet.getInt("orders_goods.count_goods"));
                line.setPrice(resultSet.getInt("orders_goods.order_line_price"));
                order.setStatus(resultSet.getString("status.status"));
                order.setId(resultSet.getInt("orders.order_id"));
                order.setClientId(resultSet.getInt("orders.client_id"));
                order.setChangeStatusDate(convertToGD(resultSet.getDate("order_status.order_status_date")));
                for (Order order1 : orders) {
                    if (order1.getId() == order.getId()) {
                        order1.addNewLine(line);
                        temp = true;
                    }
                }
                if(!temp){
                    order.addNewLine(line);
                    orders.add(order);
                }
            }
        } catch (Exception e) {
            throw new DaoException(e + "error with pars result set");
        }
        return orders;
    }

    @Override
    public void statementUpdate(PreparedStatement statement, Order obj) throws DaoException {
        try {
            statement.setInt(1, obj.getId());
            statement.setString(2, obj.getStatus());
        } catch (SQLException e) {
            throw new DaoException(e + "error with statement update");
        }
    }

    @Override
    public void statementInsert(PreparedStatement statement, Order obj) throws DaoException {
        try {
            statement.setInt(1, obj.getClientId());
        } catch (SQLException e) {
            throw new DaoException(e + "error with statement insert");
        }
    }

    @Override
    public Order create() throws DaoException {
        throw new NotImplementedException("Not implemented");
    }
}