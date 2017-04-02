package com.stef.Meetings.Task1302;

import org.apache.log4j.Logger;

import java.io.*;
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

    public static void addProduct() {
        Scanner in = new Scanner(System.in);
        String description = "";
        double price = 0;
        int repeat = -1;
        do {
            System.out.print("Enter product description: ");
            description = in.next();
            System.out.print("Enter price of product: ");
            price = in.nextDouble();
            goods.add(new Product(description, price));

            System.out.println("Add another product?");
            System.out.print("1-YES / 0-NO :");
            repeat = in.nextInt();

        } while (repeat != 0);

        saveProductToFile();


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

    public static void saveProductToFile() {
        try {
            FileOutputStream file = new FileOutputStream("product_catalog.ser");
            ObjectOutputStream obj = new ObjectOutputStream(file);

            obj.writeObject(goods);
            file.close();
            obj.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadProductFromFIle() {
        try {
            FileInputStream file = new FileInputStream("product_catalog.ser");
            ObjectInputStream obj = new ObjectInputStream(file);

            goods = (ArrayList<Product>) obj.readObject();
            file.close();
            obj.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
        int oldMaxID = 0;

        for(Product product : goods){
            if(product.getItemID()>oldMaxID){
                oldMaxID=product.getItemID();
            }
        }
        Product.setNextID(oldMaxID+1);


    }
}
