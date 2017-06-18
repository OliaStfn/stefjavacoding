package com.stef.Meetings.Task1302;

import java.io.Serializable;

public class Product implements Serializable {
    private String description;
    private double price;
    private static int nextID = 1;
    private int itemID;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID() {
        itemID = nextID;
        nextID++;
    }

    public Product(String description, double price) {
        this.description = description;
        this.price = price;
        setItemID();
    }

    public Product() {
        description = "none";
        price = 0;
        setItemID();
    }

    public static void setNextID(int id) {
        nextID = id;
    }

    public static Product create() {
        return new Product();
    }

    @Override
    public String toString() {
        return "Goods{ " +
                "itemID = " + itemID +
                " description = '" + description + '\'' +
                ", price = " + price +
                '}';
    }
}
