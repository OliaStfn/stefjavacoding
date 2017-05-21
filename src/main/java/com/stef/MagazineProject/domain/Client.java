package com.stef.MagazineProject.domain;

import com.stef.MagazineProject.dao.Identifacators;

import java.util.GregorianCalendar;

public class Client extends Human implements Identifacators<Integer> {
    private int id;
    private String phoneNumber;
    private String address;

    public Client() {
        setName("name");
        setSurname("surname");
        setBornDate(new GregorianCalendar(1990, 01, 01));
        phoneNumber = "none";
        address = "none";
    }

    public Client(String name, String surname,
                  int year, int month, int day,
                  String phoneNumber, String address) {
        setName(name);
        setSurname(surname);
        setBornDate(new GregorianCalendar(year, month, day));
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

    protected void setId(int id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "Name: " + getName() +
                ", Surname: " + getSurname() +
                ", Born Date: " + getBornDate().get(GregorianCalendar.DATE) +
                "." + getBornDate().get(GregorianCalendar.MONTH) +
                "." + getBornDate().get(GregorianCalendar.YEAR) +
                ", phoneNumber: " + phoneNumber +
                ", address: " + address +
                '}';
    }
}
