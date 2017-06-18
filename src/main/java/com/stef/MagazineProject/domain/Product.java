package com.stef.MagazineProject.domain;


import com.stef.MagazineProject.dao.Identificators;
import com.stef.MagazineProject.support.ISort;

import java.util.GregorianCalendar;

public class Product implements Identificators<Integer>,ISort {
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

    public int getId() {
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
        System.out.println("Expiration date is :" + expDate.getTime());
    }

    public void setProductionDate(GregorianCalendar productionDate) {
        this.productionDate = productionDate;
    }

    public void setExpDate(GregorianCalendar expDate) {
        this.expDate = expDate;
    }

    public GregorianCalendar getProductionDate() {
        return productionDate;
    }

    public GregorianCalendar getExpDate() {
        return expDate;
    }

    @Override
    public String toString() {
        return "Product: " +
                "\n |\t Name: \t\t\t\t|\t" + name +
                "\n |\t Price: \t\t\t|\t" + price +
                "\n |\t vendor: \t\t\t|\t" + vendor +
                "\n |\t Production Date: \t|\t" +  getProductionDate().get(GregorianCalendar.DATE) +
                "." + getProductionDate().get(GregorianCalendar.MONTH) +
                "." + getProductionDate().get(GregorianCalendar.YEAR) +
                "\n |\t Expiration Date: \t|\t" + getExpDate().get(GregorianCalendar.DATE) +
                "." + getExpDate().get(GregorianCalendar.MONTH) +
                "." + getExpDate().get(GregorianCalendar.YEAR);
    }

    @Override
    public String getWordForSort() {
        return getName();
    }

    @Override
    public double getPriceForSort() {
        return getPrice();
    }
}
