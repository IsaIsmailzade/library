package com.example.isa.library.service;

import com.example.isa.library.dao.UserDao;
import com.example.isa.library.dto.CreateUserDto;
import com.example.isa.library.dto.UserDto;
import com.example.isa.library.entity.UsersEntity;
import com.example.isa.library.mapper.CreateUserMapper;
import com.example.isa.library.mapper.UsersEntityMapper;
import lombok.SneakyThrows;

import java.util.Optional;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    UserDao userDao = UserDao.getInstance();
    UsersEntityMapper usersEntityMapper = UsersEntityMapper.getInstance();
    CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password)
                .map(usersEntityMapper::mapFrom);
    }

    @SneakyThrows
    public Long create(CreateUserDto createUserDto) {
        UsersEntity usersEntity = createUserMapper.mapFrom(createUserDto);
        userDao.save(usersEntity);
        return usersEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
