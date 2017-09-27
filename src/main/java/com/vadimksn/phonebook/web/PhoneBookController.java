package com.vadimksn.phonebook.web;

import com.vadimksn.phonebook.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneBookController {

    @Autowired
    ContactService contactService;

    @RequestMapping("/test")
    public String hello() {
        return contactService.getListAllContacts().get(0).toString();
    }
}
