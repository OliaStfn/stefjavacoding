package com.stef.Meetings.lesson13_GRASP;

public class MainStock {
    private static Stock<Appliances> ForAppliances = new Stock<Appliances>();
    private static Stock<PetSupplies> ForPetSupplies = new Stock<PetSupplies>();

    public static void addProductToAppliancesStock() {
        ForAppliances.addAppliances();
    }

    public static void addProductToPetSuppliesStock() {
        ForPetSupplies.addPetSupplies();
    }

    public static void loadProductFromFIle() {
        ForPetSupplies.loadProductFromFIle("pet_supplies");
        ForAppliances.loadProductFromFIle("appliances");
    }
}
