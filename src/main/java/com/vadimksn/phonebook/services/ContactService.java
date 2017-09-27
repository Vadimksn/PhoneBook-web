package com.vadimksn.phonebook.services;

import java.util.List;

public interface ContactService<EntityModel> {

    void addContact(EntityModel entityModel);

    void editContact(EntityModel entityModel, int contactId);

    void updateAddressAddPhone(EntityModel entityModel);

    void deleteContact(EntityModel entityModel);

    EntityModel findContactById(int contactId);

    boolean isExistContact(EntityModel entityModel);

    List<EntityModel> getListAllContacts();
}
