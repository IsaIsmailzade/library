package com.example.isa.library.dao;

import com.example.isa.library.entity.BooksEntity;

import java.util.List;
import java.util.Optional;

public class BooksDao implements Dao<Long, BooksEntity> {
    @Override
    public List<BooksEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<BooksEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(BooksEntity entity) {

    }

    @Override
    public BooksEntity save(BooksEntity entity) {
        return null;
    }
}
