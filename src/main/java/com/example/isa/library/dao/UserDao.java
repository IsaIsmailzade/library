package com.example.isa.library.dao;

import com.example.isa.library.entity.Role;
import com.example.isa.library.entity.UsersEntity;
import com.example.isa.library.util.ConnectionManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao implements Dao<Long, UsersEntity> {

    private static final UserDao INSTANCE = new UserDao();

    private static final String FIND_ALL_SQL = """
            SELECT * FROM users
            """;
    private static final String FIND_BY_ID_SQL = """
            SELECT * FROM users
            WHERE id = ?
            """;
    private static final String SAVE_SQL = """
            INSERT INTO users (name, surname, email, password, phone, role) VALUES (?, ?, ?, ?, ?, ?)
            """;
    private static final String FIND_BY_EMAIL_AND_PASSWORD_SQL = """
            SELECT * FROM users
            WHERE email = ? AND password = ?
            """;

    @SneakyThrows
    public Optional<UsersEntity> findByEmailAndPassword(String email, String password) {
        try (Connection connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_EMAIL_AND_PASSWORD_SQL)) {
            preparedStatement.setObject(1, email);
            preparedStatement.setObject(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            UsersEntity users = null;
            if (resultSet.next()) {
                users = buildEntity(resultSet);
            }
            return Optional.ofNullable(users);
        }
    }

    private UsersEntity buildEntity(ResultSet resultSet) throws SQLException {
        return UsersEntity.builder()
                .id(resultSet.getObject("id", Long.class))
                .name(resultSet.getObject("name", String.class))
                .surname(resultSet.getObject("surname", String.class))
                .email(resultSet.getObject("email", String.class))
                .password(resultSet.getObject("password", String.class))
                .phone(resultSet.getObject("phone", Integer.class))
                .role(Role.valueOf(resultSet.getObject("role", String.class)))
                .build();
    }

    @Override
    public List<UsersEntity> findAll() {
        try (Connection connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            ResultSet resultSet = prepareStatement.executeQuery();

            List<UsersEntity> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(buildUser(resultSet));
            }

            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UsersEntity> findUserById(Long id) {
        try (Connection connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            ResultSet resultSet = prepareStatement.executeQuery();

            prepareStatement.setObject(1, id);
            List<UsersEntity> usersById = new ArrayList<>();
            while (resultSet.next()) {
                usersById.add(buildUser(resultSet));
            }

            return usersById;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    private UsersEntity buildUser(ResultSet resultSet) {
        return new UsersEntity(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("name", String.class),
                resultSet.getObject("surname", String.class),
                resultSet.getObject("email", String.class),
                resultSet.getObject("password", String.class),
                resultSet.getObject("phone", Integer.class),
                Role.valueOf(resultSet.getObject("role", String.class)),
                resultSet.getObject("blacklisted", Boolean.class)
        );
    }

    @Override
    public Optional<UsersEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(UsersEntity entity) {

    }

    @SneakyThrows
    @Override
    public UsersEntity save(UsersEntity entity) {
        try (Connection connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getName());
            preparedStatement.setObject(3, entity.getSurname());
            preparedStatement.setObject(4, entity.getEmail());
            preparedStatement.setObject(5, entity.getPhone());
            preparedStatement.setObject(6, entity.getRole().name());

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Long.class));
        }
        return null;
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}