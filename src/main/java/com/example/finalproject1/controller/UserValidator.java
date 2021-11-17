package com.example.finalproject1.controller;

import com.example.finalproject1.dto.UserDto;
import com.example.finalproject1.model.User;
import com.example.finalproject1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto user = (UserDto) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountName", "NotEmpty");
        if (user.getAccountName().length() < 6 || user.getAccountName().length() > 32) {
            errors.rejectValue("accountName", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getAccountName()) != null) {
            errors.rejectValue("accountName", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordId", "NotEmpty");
        if (user.getPasswordId().length() < 8 || user.getPasswordId().length() > 32) {
            errors.rejectValue("passwordId", "Size.userForm.password");
        }

    }
}