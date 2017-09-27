package com.vadimksn.phonebook.web;

import com.vadimksn.phonebook.data.entity.Contact;
import com.vadimksn.phonebook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phoneBook")
public class PhoneBookController {

    @Autowired
    ContactService<Contact> contactService;

    @RequestMapping(method = RequestMethod.GET)
    public List getListAllContacts() {
        return contactService.getListAllContacts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addContact(@RequestBody Contact contact) {
        if (!contactService.isExistContact(contact)) {
            contactService.addContact(contact);
        } else contactService.updateAddressAddPhone(contact);
    }
}
