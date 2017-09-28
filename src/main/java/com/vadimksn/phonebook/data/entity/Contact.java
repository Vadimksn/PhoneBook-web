package com.vadimksn.phonebook.data.entity;

import java.util.List;

public class Contact extends EntityModel {
    private String name;
    private String address;
    private String newPhoneNumber;
    private List<PhoneNumber> phoneNumbers;

    public Contact() {
    }

    public Contact(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Contact(String name, String address, String newPhoneNumber) {
        this.name = name;
        this.address = address;
        this.newPhoneNumber = newPhoneNumber;
    }

    public Contact(String name, String address, List<PhoneNumber> phoneNumbers) {
        this.name = name;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    public Contact(String name, String address, String newPhoneNumber, List<PhoneNumber> phoneNumbers) {
        this.name = name;
        this.address = address;
        this.newPhoneNumber = newPhoneNumber;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getNewPhoneNumber() {
        return newPhoneNumber;
    }

    public void setNewPhoneNumber(String newPhoneNumber) {
        this.newPhoneNumber = newPhoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", newPhoneNumber='" + newPhoneNumber + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
