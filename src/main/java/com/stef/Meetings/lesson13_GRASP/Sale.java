package com.stef.Meetings.lesson13_GRASP;

import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Sale {
    private GregorianCalendar time, date;
    ArrayList<SalesLineItem> lines;

    public GregorianCalendar getTime() {
        return time;
    }

    public void setTime(GregorianCalendar time) {
        this.time = time;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public ArrayList<SalesLineItem> getLines() {
        return lines;
    }

    public void setLines(ArrayList<SalesLineItem> lines) {
        this.lines = lines;
    }

    public Sale() {
        time = new GregorianCalendar();
        date = new GregorianCalendar();
        lines = SalesLineItem.createSaleLineItem();
    }

    public void addLine(int quantity, String description, double price) {
        SalesLineItem line = SalesLineItem.create();
        line.getProduct().setDescription(description);
        line.getProduct().setPrice(price);
        line.setQuantity(quantity);
        lines.add(line);

    }

    public double allPrice() {
        double temp = 0;
        for (int i = 0; i < lines.size(); i++) {
            temp += lines.get(i).sumLine();
        }
        return temp;
    }

    public static ArrayList<Sale> createSale(){
        return new ArrayList<Sale>();
    }

    public static Sale create(){
        return new Sale();
    }

    @Override
    public String toString() {
        return "Sale{" +
                " lines=" + lines.toString() +
                '}';

    }
}
