package com.vadimksn.phonebook.data.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Contact extends EntityModel {
    private String name;
    private String address;
    private String newPhoneNumber;
    private List<PhoneNumber> phoneNumbers;

    public Contact() {
    }

    public Contact(String name, String address, String newPhoneNumber) {
        this.name = name;
        this.address = address;
        this.newPhoneNumber = newPhoneNumber;
    }


    public Contact(int id, String name, String address, String newPhoneNumber, List<PhoneNumber> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.newPhoneNumber = newPhoneNumber;
        this.phoneNumbers = phoneNumbers;
    }

    public Contact(String name, String address, String newPhoneNumber, List<PhoneNumber> phoneNumbers) {
        this.name = name;
        this.address = address;
        this.newPhoneNumber = newPhoneNumber;
        this.phoneNumbers = phoneNumbers;
    }

    public void setPhoneNumbers(int id, String[] phoneNumbers) {
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        for (String phone : phoneNumbers) {
            phoneNumberList.add(new PhoneNumber(id, phone));
        }
        this.phoneNumbers = phoneNumberList;
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
