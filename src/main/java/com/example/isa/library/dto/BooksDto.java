package com.example.isa.library.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BooksDto {

    Long id;
    String title;
}
