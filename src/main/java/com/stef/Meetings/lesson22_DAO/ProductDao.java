package com.stef.Meetings.lesson22_DAO;

import com.stef.MagazineProject.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDao {
    public Product create(Product product)throws SQLException;
    public Product read(int id)throws SQLException;
    public void update(Product product)throws SQLException;
    public void delete(Product product)throws SQLException;
    public ArrayList <Product> readAll()throws SQLException;

}
