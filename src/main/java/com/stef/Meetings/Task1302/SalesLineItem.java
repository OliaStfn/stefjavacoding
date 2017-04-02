package com.stef.Meetings.Task1302;


public class SalesLineItem {
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
        product = new Product(description, price);
    }

    public SalesLineItem() {
        quantity = 1;
        product = new Product();
    }
    public double sumLine(){
     return quantity*product.getPrice();
    }

    @Override
    public String toString() {
        return "SalesLineItem{" +
                "quantity=" + quantity +
                ", product=" + product.toString() +
                '}';
    }
}
