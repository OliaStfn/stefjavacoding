package com.stef.Meetings.lesson13_GRASP;


import java.util.ArrayList;

public class SalesLineItem<T extends Product> {
    private int quantity;
    private Product product;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(T product) {
        this.product = product;
    }

    public SalesLineItem(int quantity, String description, double price) {
        this.quantity = quantity;
        product =  T.create();
        product.setDescription(description);
        product.setPrice(price);
        //product = new Goods(description, price);
    }

    public static SalesLineItem create() {
        return new SalesLineItem();
    }

    public static ArrayList<SalesLineItem> createSaleLineItem() {
        return new ArrayList<SalesLineItem>();
    }

    //TODO #25.02 - Перевантаження конструктора + Узагальнення

    <T extends Product> SalesLineItem(T arg) {
        quantity = 1;
        product = (T) arg;
    }

    public SalesLineItem() {
        quantity = 1;
        product =  T.create();
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
