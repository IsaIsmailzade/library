package com.example.isa.library.dto;

import com.example.isa.library.entity.Role;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {

    Long id;
    String name;
    String surname;
    String email;
    Integer phone;
    Role role;
}
