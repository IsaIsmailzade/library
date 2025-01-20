package com.example.isa.library.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateBookDto {

    String title;
    String author;
    String description;
}
