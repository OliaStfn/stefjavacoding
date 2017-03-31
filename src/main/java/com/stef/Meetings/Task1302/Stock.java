package com.stef.Meetings.Task1302;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Stock {
    private static final Logger log = Logger.getLogger(Stock.class);
    private static ArrayList<Product> goods = new ArrayList<Product>();

    public static void addProduct(String desc, double price) {
        try {
            if (price <= 0) {
                throw new Exception();
            }
            goods.add(new Product(desc, price));
        } catch (Exception e) {
            System.out.println("Price less than zero");
            log.info("Price less than zero" + e.getMessage());
        }


    }

    public static Product findProduct() {
        for (Product product : goods) {
            System.out.println(product.toString());
        }
        System.out.print("Chose your product by ID:");
        Scanner in = new Scanner(System.in);
        int inputID = in.nextInt();
        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).getItemID() == inputID) {
                inputID = i;
                break;
            }
        }
        return goods.get(inputID);
    }
}
