package com.example.isa.library.mapper;

import com.example.isa.library.dto.UserDto;
import com.example.isa.library.entity.UsersEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsersEntityMapper implements Mapper<UsersEntity, UserDto> {

    private static final UsersEntityMapper INSTANCE = new UsersEntityMapper();

    @Override
    public UserDto mapFrom(UsersEntity usersEntity) {
        return UserDto.builder()
                .name(usersEntity.getName())
                .surname(usersEntity.getSurname())
                .email(usersEntity.getEmail())
                .phone(usersEntity.getPhone())
                .build();
    }

    public static UsersEntityMapper getInstance() {
        return INSTANCE;
    }
}
