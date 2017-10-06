import com.vadimksn.phonebook.data.dao.ContactDaoImpl;
import com.vadimksn.phonebook.data.entity.Contact;
import com.vadimksn.phonebook.data.entity.PhoneNumber;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestContactDaoImpl {
    @Mock
    private static ContactDaoImpl mockedContactDao;
    private static Contact contact1;
    private static Contact contact2;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        contact1 = new Contact(1, "First", "1st address", "1111111111", Arrays.asList(
                new PhoneNumber(1, "1111111112"), new PhoneNumber(1, "1111111113"), new PhoneNumber(1, "1111111114")));
        contact2 = new Contact(2, "Second", "2nd address", "2222222222", Arrays.asList(
                new PhoneNumber(2, "2222222222"), new PhoneNumber(2, "2222222222")));
        when(mockedContactDao.getListAllContacts()).thenReturn(Arrays.asList(contact1, contact2));
        when(mockedContactDao.addContact(contact2)).thenReturn(contact2);
        when(mockedContactDao.updateAddressAddPhone(contact1)).thenReturn(contact1);
        when(mockedContactDao.isExistContact(contact1)).thenReturn(true);
    }

    @Test
    public void testGetListAllContacts() {
        List<Contact> allContacts = mockedContactDao.getListAllContacts();
        Contact myContact = allContacts.get(0);
        assertEquals(2, allContacts.size());
        assertEquals(1, myContact.getId());
        assertEquals("First", myContact.getName());
        assertEquals("1st address", myContact.getAddress());
        assertEquals("1111111111", myContact.getNewPhoneNumber());
        assertEquals(3, myContact.getPhoneNumbers().size());
    }

    @Test
    public void testIsExistContact() {
        assertEquals(true, mockedContactDao.isExistContact(contact1));
    }

    @Test
    public void testAddContact() {
        Contact myContact = mockedContactDao.addContact(contact2);
        assertNotNull(myContact);
        assertEquals(2, myContact.getId());
        assertEquals("Second", myContact.getName());
        assertEquals("2nd address", myContact.getAddress());
        assertEquals("2222222222", myContact.getNewPhoneNumber());
        assertEquals(2, myContact.getPhoneNumbers().size());
    }

    @Test
    public void testUpdateAddressAddPhone() {
        Contact myContact = mockedContactDao.updateAddressAddPhone(contact1);
        assertNotNull(myContact);
        assertEquals(1, myContact.getId());
        assertEquals("First", myContact.getName());
        assertEquals("1st address", myContact.getAddress());
        assertEquals("1111111111", myContact.getNewPhoneNumber());
        assertEquals(3, myContact.getPhoneNumbers().size());
    }
}
