package com.stef.MagazineProject.dao;

import java.io.Serializable;
import java.util.ArrayList;

public interface GenericDao<T extends Identifacators<PK>, PK extends Serializable> {
    public T create() throws DaoException;
    public T createInDB(T object) throws DaoException;
    public T read(PK key)throws DaoException;
    public void update(T obj)throws DaoException;
    public void delete(T obj)throws DaoException;
    public ArrayList<T> readAll()throws DaoException;

}
