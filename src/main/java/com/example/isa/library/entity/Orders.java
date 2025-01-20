package com.example.isa.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
public class Orders {

    Long id;
    Integer user_id;
    Integer book_id;
    Integer librarian_id;
    LocalDate issued_date;
    LocalDate return_date;
    Boolean returned = false;
}
