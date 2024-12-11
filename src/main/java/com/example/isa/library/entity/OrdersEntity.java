package com.example.isa.library.entity;

import java.time.LocalDate;

public class OrdersEntity {

    private Long id;
    private Integer user_id;
    private Integer book_id;
    private Integer librarian_id;
    private LocalDate issued_date;
    private LocalDate return_date;
    private Boolean returned = false;
}
