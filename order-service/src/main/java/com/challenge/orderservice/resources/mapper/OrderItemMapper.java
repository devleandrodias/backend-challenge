package com.challenge.orderservice.resources.mapper;

import com.challenge.orderservice.model.Address;
import com.challenge.orderservice.model.Item;
import com.challenge.orderservice.resources.v1.dtos.OrderAddressRequestDto;
import com.challenge.orderservice.resources.v1.dtos.OrderAddressResponseDto;
import com.challenge.orderservice.resources.v1.dtos.OrderItemRequestDto;
import com.challenge.orderservice.resources.v1.dtos.OrderItemResponseDto;
import lombok.NonNull;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderItemMapper {
    @Autowired
    private OrderMapper orderMapper;

    public Optional<List<OrderItemResponseDto>> serializeListToDto(@NonNull final Optional<List<Item>> itens) {

        final var serializers = new ArrayList<OrderItemResponseDto>();

        itens.ifPresent(t -> t.forEach(address -> {
            serializers.add(serializeToDto(Optional.of(address)).get());
        }));

        return Optional.of(serializers);
    }

    public Optional<OrderItemResponseDto> serializeToDto(@NonNull final Optional<Item> itens) {
        final var dto = itens.get();

        return Optional.of(OrderItemResponseDto.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .unitPrice(dto.getUnitPrice())
                .quantity(dto.getQuantity())
                .createdAt(dto.getCreatedAt())
                .build());
    }

    public Optional<List<Item>> serializeListToModel(@NonNull final Optional<List<OrderItemRequestDto>> orderItemRequest) {

        final var models = new ArrayList<Item>();

        orderItemRequest.ifPresent(t -> t.forEach(address -> {
            models.add(serializeToModel(Optional.of(address)).get());
        }));

        return Optional.of(models);
    }

    public Optional<Item> serializeToModel(@NonNull final Optional<OrderItemRequestDto> orderItemRequest) {
        final var model = orderItemRequest.get();

        return Optional.of(Item.builder()
                .id(model.getId())
                .description(model.getDescription())
                .unitPrice(model.getUnitPrice())
                .quantity(model.getQuantity())
                .build());
    }
}
