import com.vadimksn.phonebook.data.entity.Contact;
import com.vadimksn.phonebook.exception.model.BadRequestException;
import com.vadimksn.phonebook.utils.ValidationUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestValidationUtils {

    private static Contact validContact;
    private static Contact notValidContact;

    @Before
    public void init() {
        validContact = new Contact("Name", "Country, city ,street", "0630001122");
        notValidContact = new Contact("A", "123456789112345678921234567891236545", "aa");
    }

    @Test
    public void testNullValidator() {
        assertEquals(true, ValidationUtils.isNotNull(validContact.getName()));
        assertEquals(true, ValidationUtils.isNotNull(validContact.getAddress()));
        assertEquals(true, ValidationUtils.isNotNull(validContact.getNewPhoneNumber()));
    }

    @Test(expected = BadRequestException.class)
    public void testValidateName() {
        assertEquals(true, ValidationUtils.validateName(validContact.getName()));
        //Throws BadRequestException(ErrorReason.NAME_IS_LESS_THAN_2)
        ValidationUtils.validateName(notValidContact.getName());
    }

    @Test(expected = BadRequestException.class)
    public void testValidatePhoneNumber() {
        assertEquals(true, ValidationUtils.validatePhoneNumber(validContact.getNewPhoneNumber()));
        //Throws BadRequestException(ErrorReason.NOT_VALID_PHONE_NUMBER)
        ValidationUtils.validatePhoneNumber(notValidContact.getNewPhoneNumber());
    }

    @Test(expected = BadRequestException.class)
    public void testValidateAddress() {
        assertEquals(true, ValidationUtils.validateAddress(validContact.getAddress()));
        //Throws BadRequestException(ErrorReason.ADDRESS_IS_MORE_THAN_30)
        ValidationUtils.validateAddress(notValidContact.getAddress());
    }
}
