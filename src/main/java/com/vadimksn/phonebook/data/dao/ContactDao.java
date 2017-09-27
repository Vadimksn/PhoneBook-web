package com.vadimksn.phonebook.data.dao;

import java.util.List;

public interface ContactDao<EntityModel> {
    void addContact(EntityModel entityModel);

    void editContact(EntityModel entityModel, int contactId);

    void updateAddressAddPhone(EntityModel entityModel);

    void deleteContact(EntityModel entityModel);

    EntityModel findContactById(int contactId);

    boolean isExistContact(EntityModel entityModel);

    List<EntityModel> getListAllContacts();
}
