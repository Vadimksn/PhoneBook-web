package com.vadimksn.phonebook.data.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneNumber extends EntityModel {
    private int contactId;
    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumber(int contactId, String phoneNumber) {
        this.contactId = contactId;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "contactId=" + contactId +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
