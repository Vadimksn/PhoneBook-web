package com.vadimksn.phonebook;

import com.vadimksn.phonebook.configuration.ApplicationConfig;
import com.vadimksn.phonebook.data.dao.ContactDao;
import com.vadimksn.phonebook.data.entity.Contact;
import com.vadimksn.phonebook.services.ContactService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Test {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ContactService contactService = (ContactService) context.getBean("contactService");
        ContactDao contactDao = (ContactDao) context.getBean("contactDao");
//        System.out.println("Find All");
//        List<Contact> contactList = contactService.getListAllContacts();
//        for (Contact contact : contactList) {
//            System.out.println(contact);
//        }
        Contact contact = new Contact("Tim Cook","SDASDADS","13213156");
        System.out.println(contact);
        System.out.println(contactDao.isExistContact(contact));
        System.out.println(contact);
    }
}
