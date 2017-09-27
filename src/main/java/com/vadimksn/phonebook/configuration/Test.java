package com.vadimksn.phonebook.configuration;

import com.vadimksn.phonebook.data.entity.Contact;
import com.vadimksn.phonebook.services.ContactService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ContactService contactService = (ContactService) context.getBean("contactService");

        System.out.println("Find All");
        List<Contact> contactList = contactService.getListAllContacts();
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }
}
