package com.stef.Meetings.Task1302;

import java.util.ArrayList;
import java.util.Scanner;

public class Stock {
    private static ArrayList<Product> goods = new ArrayList<Product>();

    public static void addProduct(String desc, double price) {
        goods.add(new Product(desc, price));
    }
    public static Product findProduct(){
        for(Product product : goods){
            System.out.println(product.toString());
        }
        System.out.print("Chose your product by ID:");
        Scanner in = new Scanner(System.in);
        int inputID=in.nextInt();
        for (int i = 0; i <goods.size() ; i++) {
            if(goods.get(i).getItemID()==inputID){
                inputID=i;
                break;
            }
        }
        return goods.get(inputID);
    }
}
