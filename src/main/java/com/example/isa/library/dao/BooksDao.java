package com.example.isa.library.dao;

import com.example.isa.library.entity.Books;
import com.example.isa.library.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class BooksDao implements Dao<Long, Books> {

    private static final BooksDao INSTANCE = new BooksDao();
    private static final String SAVE_BOOK = """
            INSERT INTO books (title) VALUES (?)
            """;
    private static final String DELETE_BOOK = """
            DELETE FROM books WHERE title = ?
            """;

    @Override
    public List<Books> findAll() {
        return List.of();
    }

    @Override
    public Optional<Books> findById(Long id) {
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
    public void update(Books entity) {

    }

    @SneakyThrows
    @Override
    public Books save(Books entity) {
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
