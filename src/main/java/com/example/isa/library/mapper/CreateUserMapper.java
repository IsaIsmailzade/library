package com.example.isa.library.mapper;

import com.example.isa.library.dto.CreateUserDto;
import com.example.isa.library.entity.UsersEntity;

public class CreateUserMapper implements Mapper<CreateUserDto, UsersEntity> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public UsersEntity mapFrom(CreateUserDto createUserDto) {
        return UsersEntity.builder()
                .name(createUserDto.getName())
                .surname(createUserDto.getSurname())
                .email(createUserDto.getEmail())
                .password(createUserDto.getPassword())
                .phone(Integer.valueOf(createUserDto.getPhone()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
