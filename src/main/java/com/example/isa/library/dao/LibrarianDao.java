package com.example.isa.library.dao;

import com.example.isa.library.entity.LibrariansEntity;

import java.util.List;
import java.util.Optional;

public class LibrarianDao implements Dao<Long, LibrariansEntity> {

    @Override
    public List<LibrariansEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<LibrariansEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(LibrariansEntity entity) {

    }

    @Override
    public LibrariansEntity save(LibrariansEntity entity) {
        return null;
    }
}
