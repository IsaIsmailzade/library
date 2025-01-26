package com.example.isa.library.validator;

import com.example.isa.library.dto.UserDto;

public class LoginUserValidator implements Validator<UserDto> {
    @Override
    public ValidationResult isValid(UserDto object) {
        ValidationResult validationResult = new ValidationResult();
        return validationResult;
    }
}
