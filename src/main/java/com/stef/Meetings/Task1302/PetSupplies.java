package com.stef.Meetings.Task1302;

public class PetSupplies extends Product{

    private String type; // тип товару (корм,аксесуари..)
    private String forAnimal; //для собак,для котів,гризунів,птахів

    public PetSupplies(String description, double price,String type,String forAnimal) {
        super(description, price);
        this.type=type;
        this.forAnimal=forAnimal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForAnimal() {
        return forAnimal;
    }

    public void setForAnimal(String forAnimal) {
        this.forAnimal = forAnimal;
    }
}
