package com.codeacademy.eshop.user.service.validator;

import com.codeacademy.eshop.user.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Username cannot be empty!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Username cannot be empty!");
    }
}
