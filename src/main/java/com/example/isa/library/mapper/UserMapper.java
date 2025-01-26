package com.example.isa.library.mapper;

import com.example.isa.library.dto.UserDto;
import com.example.isa.library.entity.Users;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper<Users, UserDto> {

    private static final UserMapper INSTANCE = new UserMapper();

    @Override
    public UserDto mapFrom(Users users) {
        return UserDto.builder()
                .name(users.getName())
                .surname(users.getSurname())
                .email(users.getEmail())
                .phone(Integer.valueOf(users.getPhone()))
                .build();
    }

    public static UserMapper getInstance() {
        return INSTANCE;
    }
}
