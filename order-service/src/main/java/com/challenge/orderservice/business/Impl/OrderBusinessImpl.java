package com.challenge.orderservice.business.Impl;

import com.challenge.orderservice.business.OrderBusiness;
import com.challenge.orderservice.exception.OrderNotFoundException;
import com.challenge.orderservice.model.Order;
import com.challenge.orderservice.repository.OrderRepository;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderBusinessImpl implements OrderBusiness {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Optional<Order> create(@NonNull Order order) {
        return Optional.of(orderRepository.saveAndFlush(order));
    }

    @Override
    public Optional<List<Order>> read() {
        return Optional.of(orderRepository.findAll());
    }

    @Override
    public Optional<Order> update(@NonNull Order order) {
        orderRepository.findById(order.getId())
                .orElseThrow(OrderNotFoundException::new);

        return Optional.of(orderRepository.saveAndFlush(order));
    }

    @Override
    public void delete(@NonNull Integer id) {
        orderRepository.findById(id)
                .orElseThrow(OrderNotFoundException::new);

        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> findById(@NonNull Integer id) {
        return Optional.of(orderRepository.findById(id)
                .orElseThrow(OrderNotFoundException::new));
    }
}
