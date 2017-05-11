package com.stef.Meetings.Task1302;

import java.util.ArrayList;

public interface ISerializable<T> {
    void saveSaleToFile();
    ArrayList<T> loadSaleFromFIle();
}
