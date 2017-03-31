package com.stef.Meetings.Task1302;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    private static ArrayList<Sale> sales = new ArrayList<Sale>();

    public static Sale creatSale() {
        Sale temp = new Sale();
        sales.add(temp);
        return temp;
    }

    public static void addItemsToSale(Sale sale) {
        Scanner in = new Scanner(System.in);
        int repeat = -1;
        do {
            Product pr1 = Stock.findProduct();
            System.out.print("Enter quantity  of product: ");
            int quantity = in.nextInt();
            sale.addLine(quantity, pr1.getDescription(), pr1.getPrice());
            System.out.println("Add other product?");
            System.out.println("1-YES / 0-NO :");
            repeat = in.nextInt();
        } while (repeat != 0);
    }

}
