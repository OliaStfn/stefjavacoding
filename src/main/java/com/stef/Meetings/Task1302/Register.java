package com.stef.Meetings.Task1302;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Register implements Serializable {
    private static ArrayList<Sale> sales = new ArrayList<Sale>();
    private static final Logger log = Logger.getLogger(Register.class);

    public static Sale creatSale() {
        Sale temp = new Sale();
        sales.add(temp);
        return temp;
    }

    public static void addItemsToSale(Sale sale) {
        Scanner in = new Scanner(System.in);
        int repeat = -1;
        do {
            try {
                Product pr1 = Stock.findProduct();
                System.out.print("Enter quantity  of product: ");
                int quantity = in.nextInt();
                if (quantity <= 0) {
                    throw new Exception();
                }
                sale.addLine(quantity, pr1.getDescription(), pr1.getPrice());
                System.out.println("Add other product?");
                System.out.println("1-YES / 0-NO :");
                repeat = in.nextInt();
            } catch (Exception e) {
                System.out.println("Quantity less one");
                log.error("Quantity less one" + e.getMessage());
            }
        } while (repeat != 0);
    }

    public static void saveSaleToFile() {
        try {
            FileOutputStream files = new FileOutputStream("sale_catalog.ser");
            ObjectOutputStream object = new ObjectOutputStream(files);

            object.writeObject(sales);
            files.close();
            object.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadSaleFromFIle() {
        try {
            FileInputStream files = new FileInputStream("sale_catalog.ser");
            ObjectInputStream object = new ObjectInputStream(files);

            sales = (ArrayList<Sale>) object.readObject();
            files.close();
            object.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
    }
}
