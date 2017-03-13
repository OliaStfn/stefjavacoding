package com.stef.MagazineProject;

public class Client extends Human {
    private static int nextId = 1;
    private int id;
    private String phoneNumber;
    private String address;

    public Client() {
        super();
        setId();
        phoneNumber = "none";
        address = "none";
    }

    public Client(String name, String surname,
                  int year, int month, int day,
                  String phoneNumber, String address) {
        super(name, surname, year, month, day);
        setId();
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }
}
