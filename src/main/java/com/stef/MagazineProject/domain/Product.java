package com.stef.MagazineProject.domain;


import com.stef.MagazineProject.dao.Identifacators;

import java.util.GregorianCalendar;

public class Product implements Identifacators<Integer> {
    private Integer id;
    private String name;
    private double price;
    private String vendor;
    private GregorianCalendar productionDate;
    private GregorianCalendar expDate;

    public Product() {
    }

    public Product(String name, double price, String vendor, GregorianCalendar productionDate, GregorianCalendar expDate) {
        this.name = name;
        this.price = price;
        this.vendor = vendor;
        this.productionDate = productionDate;
        this.expDate = expDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void showExpDate(){
        System.out.println("Exp date is :" + expDate.getTime());
    }

    public void setProductionDate(GregorianCalendar productionDate) {
        this.productionDate = productionDate;
    }

    public void setExpDate(GregorianCalendar expDate) {
        this.expDate = expDate;
    }
}