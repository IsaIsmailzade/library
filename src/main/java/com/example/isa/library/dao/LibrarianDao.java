package com.example.isa.library.dao;

import com.example.isa.library.entity.LibrariansEntity;
import com.example.isa.library.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class LibrarianDao implements Dao<Long, LibrariansEntity> {

    private static final LibrarianDao INSTANCE = new LibrarianDao();
    private static final String SAVE_NAME = """
            INSERT INTO librarians (id) VALUES (?)
            """;
    private static final String DELETE_LIBRARIAN = """
            DELETE FROM librarians WHERE name = ?
            """;

    @Override
    public List<LibrariansEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<LibrariansEntity> findById(Long id) {
        return Optional.empty();
    }

    @SneakyThrows
    @Override
    public boolean delete(Long id) {
        try (Connection connection = ConnectionManager.get();
        var preparedStatement = connection.prepareStatement(DELETE_LIBRARIAN)) {
            preparedStatement.setObject(1, id);

            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public void update(LibrariansEntity entity) {

    }

    @SneakyThrows
    @Override
    public LibrariansEntity save(LibrariansEntity entity) {
        try (Connection connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_NAME, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();

            entity.setId(generatedKeys.getObject("id", Long.class));
        }
        return null;
    }

    public static LibrarianDao getInstance() {
        return INSTANCE;
    }
}
