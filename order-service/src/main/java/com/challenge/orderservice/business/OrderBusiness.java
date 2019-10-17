package com.challenge.orderservice.business;

import com.challenge.orderservice.model.Order;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface OrderBusiness {
    Optional<Order> create(@NonNull final Order order);
    Optional<List<Order>> read();
    Optional<Order> update(@NonNull final Order order);
    void delete(@NonNull final Integer id);
    Optional<Order> findById(@NonNull final Integer id);
}
