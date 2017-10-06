package com.vadimksn.phonebook.utils;

import com.vadimksn.phonebook.data.entity.Contact;
import com.vadimksn.phonebook.data.entity.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class FilterContactListUtils {

    public static List filter(String s, List<Contact> list) {
        List<Contact> filteredList = new ArrayList<>();
        for (Contact contact : list) {
            String row = contact.getName() + " " + contact.getAddress();
            for (PhoneNumber phoneNumber : contact.getPhoneNumbers()) {
                row = row + phoneNumber.getPhoneNumber();
            }
            if (row.toLowerCase().contains(s.toLowerCase())) {
                filteredList.add(contact);
            }
        }
        return filteredList;
    }
}
