package com.stef.Meetings.lesson13_GRASP;

public class Appliances extends Product {
    private String category;
    private String type;

    public Appliances(String description, double price, String category, String type) {
        super(description, price);
        this.category = category;
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
