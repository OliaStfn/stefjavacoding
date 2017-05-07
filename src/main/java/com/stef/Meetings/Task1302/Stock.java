package com.stef.Meetings.Task1302;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Stock<T extends Product> {
    private static final Logger log = Logger.getLogger(Stock.class);
    private ArrayList<T> goods = new ArrayList<T>();

    public void addProduct(String desc, double price) {
        try {
            if (price <= 0) {
                throw new Exception();
            }
            goods.add((T) new Product(desc, price));
        } catch (Exception e) {
            System.out.println("Price less than zero");
            log.info("Price less than zero" + e.getMessage());
        }
    }

    public void addProduct() {
        Scanner in = new Scanner(System.in);
        String description = "";
        double price = 0;
        int repeat = -1;
        do {
            System.out.print("Enter product description: ");
            description = in.next();
            System.out.print("Enter price of product: ");
            price = in.nextDouble();
            goods.add((T) new Product(description, price));

            System.out.println("Add another product?");
            System.out.print("1-YES / 0-NO :");
            repeat = in.nextInt();

        } while (repeat != 0);

        saveProductToFile();


    }

    public void addPetSupplies() {
        Scanner in = new Scanner(System.in);
        String description = "";
        double price = 0;
        String type="";
        String forAnimal="";
        int repeat = -1;
        do {
            System.out.print("Enter product description: ");
            description = in.next();
            System.out.print("Enter price of product: ");
            price = in.nextDouble();
            System.out.print("Enter type of product: ");
            type = in.next();
            System.out.print("Enter animals for which this product: ");
            forAnimal = in.next();
            goods.add((T) new PetSupplies(description, price,type,forAnimal));

            System.out.println("Add another product?");
            System.out.print("1-YES / 0-NO :");
            repeat = in.nextInt();

        } while (repeat != 0);

        saveProductToFile();
    }
    public void addAppliances() {
        Scanner in = new Scanner(System.in);
        String description = "";
        double price = 0;
        String category="";
        String type="";
        int repeat = -1;
        do {
            System.out.print("Enter product description: ");
            description = in.next();
            System.out.print("Enter price of product: ");
            price = in.nextDouble();
            System.out.print("Enter type of product: ");
            type = in.next();
            System.out.print("Enter category of product: ");
            category = in.next();
            goods.add((T) new Appliances(description, price,category,type));

            System.out.println("Add another product?");
            System.out.print("1-YES / 0-NO :");
            repeat = in.nextInt();

        } while (repeat != 0);

        saveProductToFile();
    }

    public T findProduct() {
        for (T product : goods) {
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

    public void saveProductToFile() {
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

    public void loadProductFromFIle() {
        try {
            FileInputStream file = new FileInputStream("product_catalog.ser");
            ObjectInputStream obj = new ObjectInputStream(file);

            goods = (ArrayList<T>) obj.readObject();
            file.close();
            obj.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
        int oldMaxID = 0;

        for(T product : goods){
            if(product.getItemID()>oldMaxID){
                oldMaxID=product.getItemID();
            }
        }
        T.setNextID(oldMaxID+1);


    }
}
