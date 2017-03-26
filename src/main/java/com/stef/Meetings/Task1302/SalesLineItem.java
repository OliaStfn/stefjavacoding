package com.stef.Meetings.Task1302;


public class SalesLineItem {
    private int quantity;
    ProductSpecification product;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductSpecification getProduct() {
        return product;
    }

    public void setProduct(ProductSpecification product) {
        this.product = product;
    }

    public SalesLineItem(int quantity, String description, double price) {
        this.quantity = quantity;
        product = new ProductSpecification(description, price);
    }

    public SalesLineItem() {
        quantity = 1;
        product = new ProductSpecification();
    }
    public double sumLine(){
     return quantity*product.getPrice();
    }
}
