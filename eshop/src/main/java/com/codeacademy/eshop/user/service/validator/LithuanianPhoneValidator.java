package com.codeacademy.eshop.user.service.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.codeacademy.eshop.util.StringUtil.areCharsDigits;

public class LithuanianPhoneValidator implements ConstraintValidator<LithuanianPhone, String> {

    /**
     * Phone number will be considered valid in the following cases:
     * 86xxxxxxx and +3706xxxxxxx
     * Where x has to be a number.
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.length() == 9 && value.startsWith("86")) {
                return areCharsDigits(value.substring(2));
        }
        if (value.length() == 12 && value.startsWith("+370")) {
            return areCharsDigits(value.substring(4));
        }
        return false;
    }
}
