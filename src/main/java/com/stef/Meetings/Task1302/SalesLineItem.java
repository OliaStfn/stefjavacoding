package com.stef.Meetings.Task1302;


import java.util.ArrayList;

public class SalesLineItem<T extends Product> {
    private int quantity;
    Product product;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SalesLineItem(int quantity, String description, double price) {
        this.quantity = quantity;
        product = Product.create();
        product.setDescription(description);
        product.setPrice(price);
        //product = new Product(description, price);
    }

    public static SalesLineItem create() {
        return new SalesLineItem();
    }

    public static ArrayList<SalesLineItem> createSaleLineItem() {
        return new ArrayList<SalesLineItem>();
    }

    //TODO #25.02 - Перевантаження конструктора + Узагальнення

    public SalesLineItem() {
        quantity = 1;
        product = Product.create();
    }

    public double sumLine() {
        return quantity * product.getPrice();
    }

    @Override
    public String toString() {
        return "SalesLineItem{" +
                "quantity=" + quantity +
                ", product=" + product.toString() +
                '}';
    }
}
