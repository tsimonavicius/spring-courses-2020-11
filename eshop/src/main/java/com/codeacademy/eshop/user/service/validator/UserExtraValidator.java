package com.codeacademy.eshop.user.service.validator;

import com.codeacademy.eshop.user.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserExtraValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "validation.zip.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "validation.phone.empty");
    }
}
