package com.challenge.orderservice.resources.mapper;

import com.challenge.orderservice.model.Order;
import com.challenge.orderservice.resources.v1.dtos.OrderRequestDto;
import com.challenge.orderservice.resources.v1.dtos.OrderResponseDto;
import lombok.NonNull;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderMapper {
    public Optional<List<OrderResponseDto>> serializeListToDto(@NonNull final Optional<List<Order>> orders) {

        final var serializers = new ArrayList<OrderResponseDto>();

        orders.ifPresent(t -> t.forEach(order -> {
            serializers.add(serializeToDto(Optional.of(order)).get());
        }));

        return Optional.of(serializers);
    }

    public Optional<OrderResponseDto> serializeToDto(@NonNull final Optional<Order> order) {
        final var dto = order.get();

        return Optional.of(OrderResponseDto.builder()
                .id(dto.getId())
                .confirmationDate(dto.getConfirmationDate())
                .createdAt(dto.getCreatedAt())
                .build());
    }

    public Optional<Order> serializeToModel(@NonNull final Optional<OrderRequestDto> orderRequest) {
        final var model = orderRequest.get();

        return Optional.of(Order.builder()
                .id(model.getId())
                .confirmationDate(model.getConfirmationDate())
                .createdAt(model.getCreatedAt())
                .build());
    }
}
