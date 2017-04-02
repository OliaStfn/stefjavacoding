package com.stef.Meetings.Task1302;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
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

}
