package com.stef.Meetings.lesson22_DAO;

import com.stef.MagazineProject.Product;

import java.util.ArrayList;

public interface ProductDao {
    public Product create();
    public Product read(int id);
    public void update(Product product);
    public void delete(Product product);
    public ArrayList <Product> readAll();

}
