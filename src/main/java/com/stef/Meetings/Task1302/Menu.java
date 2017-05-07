package com.stef.Meetings.Task1302;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int x = -1;
        System.out.println("Welcome to the internet shop");
        do {
            printMenu();
            x=choice();
            doIt(x);
        } while (x != 0);
    }

    private static void printMenu() {
        System.out.println("You can choose one of the point to continue");
        System.out.println("1- Add product");
        System.out.println("2- Buy product");
        System.out.println("0- Exit");

    }

    private static int choice() {
        Scanner in = new Scanner(System.in);
        int temp = -1;
        do {
            System.out.println("Enter your choice: ");
            temp = in.nextInt();
        } while (temp < 0 || temp >= 7);

        return temp;
    }

    private static void doIt(int x) {
        MainStock.loadProductFromFIle();
        switch (x) {
            case 1: MainStock.addProductToAppliancesStock();

                break;
            case 2://Register.addItemsToSale(Register.creatSale());
                break;
            case 0: System.exit(0);
        }
    }
}

