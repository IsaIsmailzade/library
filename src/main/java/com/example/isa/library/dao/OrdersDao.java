package com.example.isa.library.dao;

import com.example.isa.library.entity.OrdersEntity;

import java.util.List;
import java.util.Optional;

public class OrdersDao implements Dao<Long, OrdersEntity> {

    @Override
    public List<OrdersEntity> findAll() {
        return List.of();
    }

    @Override
    public Optional<OrdersEntity> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(OrdersEntity entity) {

    }

    @Override
    public OrdersEntity save(OrdersEntity entity) {
        return null;
    }
}
