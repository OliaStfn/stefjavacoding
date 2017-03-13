package com.stef.MagazineProject;

public class Manager extends Employee {
    private int productofStock;

    public int getProductofStock() {
        return productofStock;
    }

    public void setProductofStock(int productofStock) {
        this.productofStock = productofStock;
    }

    @Override
    public void raiseSalary() {
        setSalary(getSalary()+getSalary()*0.15);
    }
}
