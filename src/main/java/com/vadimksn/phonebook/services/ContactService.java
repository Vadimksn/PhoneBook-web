package com.vadimksn.phonebook.services;

import java.util.List;

public interface ContactService<EntityModel> {

    EntityModel addContact(EntityModel entityModel);

    void editContact(EntityModel entityModel, int contactId);

    EntityModel updateAddressAddPhone(EntityModel entityModel);

    void deleteContact(EntityModel entityModel);

    EntityModel findContactById(int contactId);

    boolean isExistContact(EntityModel entityModel);

    List<EntityModel> getListAllContacts();
}
