package com.example.isa.library.service;

import com.example.isa.library.dao.AdminDao;
import com.example.isa.library.dto.AdminDto;
import com.example.isa.library.dto.CreateBookDto;
import com.example.isa.library.entity.Books;
import com.example.isa.library.entity.Users;
import com.example.isa.library.mapper.AdminMapper;
import lombok.Getter;

import java.util.Optional;

public class AdminService {

    @Getter
    private static final AdminService INSTANCE = new AdminService();
    AdminDao adminDao = AdminDao.getINSTANCE();
    AdminMapper adminMapper = AdminMapper.getINSTANCE();

    public Optional<AdminDto> login(String email, String password) {
        return adminDao.findByEmailAndPassword(email, password)
                .map(adminMapper::mapFrom);
    }
}
