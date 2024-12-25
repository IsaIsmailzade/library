package com.example.isa.library.service;

import com.example.isa.library.dao.UserDao;
import com.example.isa.library.dto.CreateUserDto;
import com.example.isa.library.dto.UserDto;
import com.example.isa.library.entity.Users;
import com.example.isa.library.exception.ValidationException;
import com.example.isa.library.mapper.CreateUserMapper;
import com.example.isa.library.mapper.UserMapper;
import com.example.isa.library.validator.CreateUserValidator;
import com.example.isa.library.validator.ValidationResult;
import lombok.SneakyThrows;

import java.util.Optional;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    UserDao userDao = UserDao.getInstance();
    UserMapper usersEntityMapper = UserMapper.getInstance();
    CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    CreateUserValidator createUserValidator = CreateUserValidator.getInstance();

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password)
                .map(usersEntityMapper::mapFrom);
    }

    @SneakyThrows
    public Long create(CreateUserDto createUserDto) {
        ValidationResult valid = createUserValidator.isValid(createUserDto);
        if (!valid.isValid()) {
            throw new ValidationException(valid.getErrors());
        }
        Users users = createUserMapper.mapFrom(createUserDto);
        userDao.save(users);
        return users.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
