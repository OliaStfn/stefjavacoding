package com.stef.Meetings.Task1302;

public interface ISerializable<T> {
    void saveSaleToFile(String path, T obj);
    T loadSaleFromFIle(String path);
}
