package com.stef.MagazineProject;

public class Client extends Human {
    private int id;
    private String phoneNumber;
    private String address;

    public Client() {
        super();
        phoneNumber = "none";
        address = "none";
    }

    public Client(String name, String surname,
                  int year, int month, int day,
                  String phoneNumber, String address) {
        super(name, surname, year, month, day);
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
}
