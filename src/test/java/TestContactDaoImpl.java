import com.vadimksn.phonebook.configuration.ApplicationConfig;
import com.vadimksn.phonebook.data.dao.ContactDao;
import com.vadimksn.phonebook.data.entity.Contact;
import com.vadimksn.phonebook.data.entity.PhoneNumber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@Transactional
public class TestContactDaoImpl {

    private String number = "0000000001";
    private String name = "Add Test";
    private String address = "Add Street";
    private PhoneNumber phoneNumber = new PhoneNumber(number);
    private List<PhoneNumber> phoneNumbers = new ArrayList();
    private Contact contact = new Contact(name, address, number, phoneNumbers);

    @Autowired
    private ContactDao<Contact> contactDao;

    @Test
    @Transactional
    @Rollback()
    public void testAddContact() {
        phoneNumbers.add(phoneNumber);
        contact.setPhoneNumbers(phoneNumbers);
        contactDao.addContact(contact);

        List<Contact> contacts = contactDao.getListAllContacts();
        List<PhoneNumber> phoneNumbers = contacts.get(contacts.size() - 1).getPhoneNumbers();
        Assert.assertEquals(contact.getName(), contacts.get(contacts.size() - 1).getName());
        Assert.assertEquals(contact.getAddress(), contacts.get(contacts.size() - 1).getAddress());
        Assert.assertEquals(contact.getPhoneNumbers().get(0).getPhoneNumber(), phoneNumbers.get(phoneNumbers.size() - 1).getPhoneNumber());
    }

    @Test
    @Transactional
    @Rollback()
    public void testUpdateContact() {
        contact.setName("Test Update");
        contactDao.addContact(contact);
        contact.setAddress("Updated address");
        contact.setNewPhoneNumber("0000000002");
        contactDao.updateAddressAddPhone(contact);

        List<Contact> contacts = contactDao.getListAllContacts();
        List<PhoneNumber> phoneNumbers = contacts.get(contacts.size() - 1).getPhoneNumbers();
        Assert.assertEquals(contact.getAddress(), contacts.get(contacts.size() - 1).getAddress());
        Assert.assertEquals(contact.getNewPhoneNumber(), phoneNumbers.get(phoneNumbers.size() - 1).getPhoneNumber());
    }

    @Test
    @Transactional
    @Rollback()
    public void testIsExistContact() {
        Contact contact = new Contact("Test IsExist", "Exist street", "0000000000");
        contactDao.addContact(contact);
        Assert.assertEquals(true, contactDao.isExistContact(contact));
    }


}
