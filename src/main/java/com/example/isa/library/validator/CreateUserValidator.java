package com.example.isa.library.validator;

import com.example.isa.library.dto.CreateUserDto;

public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();
    private static final String PATTERN = "^\\+?\\d{11,12}$";

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        ValidationResult validationResult = new ValidationResult();

        if (!object.getPhone().matches(PATTERN)) {
            validationResult.add(Error.of("invalid.phone", "Phone is invalid"));
        }

        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
