package com.example.isa.library.dao;

import com.example.isa.library.entity.BooksEntity;
import com.example.isa.library.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class BooksDao implements Dao<Long, BooksEntity> {

    private static final BooksDao INSTANCE = new BooksDao();
    private static final String SAVE_BOOK = """
            INSERT INTO books (title) VALUES (?)
            """;
    private static final String DELETE_BOOK = """
            DELETE FROM books WHERE title = ?
            """;

    @Override
    public List<BooksEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<BooksEntity> findById(Long id) {
        return Optional.empty();
    }

    @SneakyThrows
    @Override
    public boolean delete(Long id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK)) {
            preparedStatement.setObject(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public void update(BooksEntity entity) {

    }

    @SneakyThrows
    @Override
    public BooksEntity save(BooksEntity entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_BOOK, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getTitle());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Long.class));
        }
        return null;
    }

    public static BooksDao getInstance() {
        return INSTANCE;
    }
}
