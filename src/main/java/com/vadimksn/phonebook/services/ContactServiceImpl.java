package com.vadimksn.phonebook.services;

import com.vadimksn.phonebook.data.dao.ContactDao;
import com.vadimksn.phonebook.data.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactService")
public class ContactServiceImpl implements ContactService<Contact> {

    @Autowired
    ContactDao contactDao;

    @Override
    public void addContact(Contact contact) {
        contactDao.addContact(contact);
    }

    @Override
    public void editContact(Contact contact, int contactId) {
        contactDao.editContact(contact, contactId);
    }

    @Override
    public void updateAddressAddPhone(Contact contact) {
        contactDao.updateAddressAddPhone(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactDao.deleteContact(contact);
    }

    @Override
    public Contact findContact(int contactId) {
        return (Contact) contactDao.findContact(contactId);
    }

    @Override
    public List<Contact> getListAllContacts() {
        return contactDao.getListAllContacts();
    }
}
