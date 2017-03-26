package com.stef.Meetings.Task1302;

public class Product {
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

    @Override
    public String toString() {
        return "Product{" +
                "itemID=" + itemID +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
