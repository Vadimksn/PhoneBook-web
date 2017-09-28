package com.vadimksn.phonebook.web;

import com.vadimksn.phonebook.data.entity.Contact;
import com.vadimksn.phonebook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.vadimksn.phonebook.utils.ValidationUtils.validateContact;

@RestController
@RequestMapping("/contacts")
public class PhoneBookController {

    @Autowired
    ContactService<Contact> contactService;

    @RequestMapping(method = RequestMethod.GET)
    public List getListAllContacts() {
        return contactService.getListAllContacts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Contact addContact(@RequestBody Contact contact) {
        validateContact(contact);
        if (contactService.isExistContact(contact)) {
            return contactService.updateAddressAddPhone(contact);
        } else {
            return contactService.addContact(contact);
        }
    }
}
