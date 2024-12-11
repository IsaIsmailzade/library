package com.example.isa.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UsersEntity {

    Long id;
    String name;
    String surname;
    String email;
    String password;
    Integer phone;
    Role role;
    Boolean blacklisted = false;
}
