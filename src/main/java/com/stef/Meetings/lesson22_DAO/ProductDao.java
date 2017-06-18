package com.stef.Meetings.lesson22_DAO;

import com.stef.MagazineProject.domain.Goods;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDao {
    public Goods create(Goods goods)throws SQLException;
    public Goods read(int id)throws SQLException;
    public void update(Goods goods)throws SQLException;
    public void delete(Goods goods)throws SQLException;
    public ArrayList <Goods> readAll()throws SQLException;

}
