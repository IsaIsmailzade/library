package com.example.isa.library.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
