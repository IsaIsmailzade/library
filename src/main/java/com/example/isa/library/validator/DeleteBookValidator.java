package com.example.isa.library.validator;

import lombok.Getter;

public class DeleteBookValidator implements Validator<String> {

    @Getter
    private static final DeleteBookValidator INSTANCE = new DeleteBookValidator();
    private static final String ID_PATTERN = "^\\d+$";

    @Override
    public ValidationResult isValid(String id) {
        ValidationResult validationResult = new ValidationResult();

        if (id == null || !id.matches(ID_PATTERN)) {
            validationResult.add(Error.of("bookId.invalid", "Invalid book ID"));
        }

        return validationResult;
    }
}
