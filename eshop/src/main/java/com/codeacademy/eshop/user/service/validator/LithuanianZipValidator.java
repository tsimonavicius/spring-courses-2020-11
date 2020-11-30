package com.codeacademy.eshop.user.service.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.codeacademy.eshop.util.StringUtil.areCharsDigits;

public class LithuanianZipValidator implements ConstraintValidator<LithuanianZip, String> {

    /**
     * Zip code will be considered valid in the following cases:
     * LTxxxxx and LT-xxxxx
     * Where x has to be a number.
     * The number will be considered valid if it will be null.
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        if (value.length() == 7 && value.startsWith("LT")) {
                return areCharsDigits(value.substring(2));
        }
        if (value.length() == 8 && value.startsWith("LT-")) {
            return areCharsDigits(value.substring(3));
        }
        return false;
    }
}
