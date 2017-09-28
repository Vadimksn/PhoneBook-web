package com.vadimksn.phonebook.utils;

import com.vadimksn.phonebook.data.entity.Contact;
import com.vadimksn.phonebook.exception.ErrorReason;
import com.vadimksn.phonebook.exception.model.BadRequestException;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    private static final Pattern VALID_PHONE_NUMBER_REGEX =
            Pattern.compile("^\\+?[0-9() ]{10,20}$");

    public static void validateContact(Contact contact) {
        validateName(contact.getName());
        validateAddress(contact.getAddress());
        validatePhoneNumber(contact.getNewPhoneNumber());
    }

    private static void nullValidator(String param) {
        if (param == null) {
            throw new BadRequestException(ErrorReason.VALIDATION_PARAMETER_IS_NULL);
        }
    }

    private static void validateName(String name) {
        nullValidator(name);
        if (StringUtils.length(name) < 2) {
            throw new BadRequestException(ErrorReason.NAME_IS_LESS_THAN_2, name);
        }else if (StringUtils.length(name) > 20) {
            throw new BadRequestException(ErrorReason.NAME_IS_MORE_THAN_20, name);
        }
    }

    private static void validatePhoneNumber(String mobilePhone) {
        nullValidator(mobilePhone);
        Matcher matcher = VALID_PHONE_NUMBER_REGEX.matcher(mobilePhone);
        if (!matcher.matches()) {
            throw new BadRequestException(ErrorReason.NOT_VALID_PHONE_NUMBER, mobilePhone);
        }
    }

    private static void validateAddress(String address) {
        nullValidator(address);
        if (StringUtils.length(address) < 5) {
            throw new BadRequestException(ErrorReason.ADDRESS_IS_LESS_THAN_5, address);
        }else if (StringUtils.length(address) > 30) {
            throw new BadRequestException(ErrorReason.ADDRESS_IS_MORE_THAN_30, address);
        }
    }

}
