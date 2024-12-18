package com.example.isa.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Librarians {

    private Long id;
    private String name;
}
