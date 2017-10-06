import com.vadimksn.phonebook.data.dao.ContactDaoImpl;
import com.vadimksn.phonebook.data.entity.Contact;
import com.vadimksn.phonebook.data.entity.PhoneNumber;
import com.vadimksn.phonebook.utils.FilterContactListUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestFilterContactListUtils {
    @Mock
    private static ContactDaoImpl mockedContactDao;
    private static Contact contact1;
    private static Contact contact2;
    private static Contact contact3;
    private static Contact contact4;
    private static Contact contact5;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        contact1 = new Contact("Bob Smith", "Baker street", Arrays.asList(
                new PhoneNumber("1111111"), new PhoneNumber("2222"), new PhoneNumber("3333")));
        contact2 = new Contact("John Smith", "Baker street", Arrays.asList(
                new PhoneNumber("1111111"), new PhoneNumber("12332")));
        contact3 = new Contact("Lola Smith", "Baker street", Arrays.asList(
                new PhoneNumber("1111111"), new PhoneNumber("777777")));
        contact4 = new Contact("Karas Mokryi", "River street", Arrays.asList(
                new PhoneNumber("043255555")));
        contact5 = new Contact("Galyna Stepanivna", "Lenin street", Arrays.asList(
                new PhoneNumber("112"), new PhoneNumber("911")));
        when(mockedContactDao.getListAllContacts()).thenReturn(Arrays.asList(contact1, contact2, contact3, contact4, contact5));
    }

    @Test
    public void testFilter() {
        List list = mockedContactDao.getListAllContacts();
        assertEquals(3, FilterContactListUtils.filter("smith", list).size());
        assertEquals(0, FilterContactListUtils.filter("OLOLO", list).size());
        assertEquals(4, FilterContactListUtils.filter("1", list).size());
        assertEquals(1, FilterContactListUtils.filter("gaLYna", list).size());
        assertEquals(5, FilterContactListUtils.filter("strEEt", list).size());
    }
}
