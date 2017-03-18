package com.stef.MagazineProject;

import java.util.GregorianCalendar;

public class Client extends Human {
    private static int nextId = 1;
    private int id;
    private String phoneNumber;
    private String address;

    public Client() {
        setName("name");
        setSurname("surname");
        setBornDate(new GregorianCalendar(1990, 01, 01));
        setId();
        phoneNumber = "none";
        address = "none";
    }

    public Client(String name, String surname,
                  int year, int month, int day,
                  String phoneNumber, String address) {
        setName(name);
        setSurname(surname);
        setBornDate(new GregorianCalendar(year, month, day));
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
