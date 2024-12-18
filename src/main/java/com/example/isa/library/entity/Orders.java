package com.example.isa.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
public class Orders {

    private Long id;
    private Integer user_id;
    private Integer book_id;
    private Integer librarian_id;
    private LocalDate issued_date;
    private LocalDate return_date;
    private Boolean returned = false;
}
