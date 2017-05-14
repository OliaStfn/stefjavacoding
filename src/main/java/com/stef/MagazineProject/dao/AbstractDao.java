package com.stef.MagazineProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class AbstractDao<T, PK extends Integer> implements GenericDao<T, PK> {
    private Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public abstract String getSelectQuery();

    public abstract ArrayList<T> parseResultSet(ResultSet resultSet) throws DaoException;

    @Override
    public T create() throws DaoException {
        return null;
    }

    @Override
    public T create(T object) throws DaoException {
        return null;
    }

    @Override
    public T read(PK key) throws DaoException {
        ArrayList<T> someList;
        String query = getSelectQuery();
        query += " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, key);
            ResultSet resultSet = statement.executeQuery();
            someList = parseResultSet(resultSet);

        } catch (Exception e) {
            throw new DaoException();
        }
        if(someList==null || someList.size()==0){
            throw new DaoException("Record with id="+key+" not found in database");
        }
        if(someList.size()>1){
            throw new DaoException("Found more than one record with id="+key);
        }
        return someList.iterator().next();
    }

    @Override
    public void update(T obj) throws DaoException {

    }

    @Override
    public void delete(T obj) throws DaoException {

    }

    @Override
    public ArrayList<T> readAll() throws DaoException {
        
        return null;
    }
}
