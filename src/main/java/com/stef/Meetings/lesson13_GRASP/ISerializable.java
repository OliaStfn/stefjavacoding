package com.stef.Meetings.lesson13_GRASP;

public interface ISerializable<T> {
    void saveSaleToFile(String path, T obj);
    T loadSaleFromFIle(String path);
}
