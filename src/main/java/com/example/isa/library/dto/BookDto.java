package com.example.isa.library.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookDto {

    Long id;
    String title;
    String author;
    String description;
}
