package com.example.isa.library.mapper;

import com.example.isa.library.dto.UserDto;
import com.example.isa.library.entity.Users;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsersEntityMapper implements Mapper<Users, UserDto> {

    private static final UsersEntityMapper INSTANCE = new UsersEntityMapper();

    @Override
    public UserDto mapFrom(Users users) {
        return UserDto.builder()
                .name(users.getName())
                .surname(users.getSurname())
                .email(users.getEmail())
                .phone(users.getPhone())
                .build();
    }

    public static UsersEntityMapper getInstance() {
        return INSTANCE;
    }
}
