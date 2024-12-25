package com.example.isa.library.exception;

import com.example.isa.library.validator.Error;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ValidationException extends RuntimeException {

    private final List<Error> errors;
}
