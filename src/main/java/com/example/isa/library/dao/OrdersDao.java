package com.example.isa.library.dao;

import com.example.isa.library.entity.Orders;
import com.example.isa.library.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class OrdersDao implements Dao<Long, Orders> {

    private static final OrdersDao INSTANCE = new OrdersDao();

    private static final String DELETE = "DELETE FROM orders WHERE user_id = ?";
    private static final String SAVE = """
            INSERT INTO orders (id, user_id, book_id, librarian_id, issued_date, return_date)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

    @Override
    public List<Orders> findAll() {
        return List.of();
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return Optional.empty();
    }

    @SneakyThrows
    @Override
    public boolean delete(Long id) {
        try (Connection connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setObject(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    @Override
    public void update(Orders entity) {

    }

    @SneakyThrows
    @Override
    public Orders save(Orders entity) {
        try (Connection connection = ConnectionManager.get();
        var preparedStatement = connection.prepareStatement(SAVE, RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getUser_id());
            preparedStatement.setObject(3, entity.getBook_id());
            preparedStatement.setObject(4, entity.getLibrarian_id());
            preparedStatement.setObject(5, entity.getIssued_date());
            preparedStatement.setObject(6, entity.getReturn_date());

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Long.class));
        }
        return null;
    }

    public static OrdersDao getInstance() {
        return INSTANCE;
    }
}
