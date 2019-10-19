package com.challenge.saleservice.resources.mapper;

import com.challenge.saleservice.model.Item;
import com.challenge.saleservice.resources.v1.dtos.SaleItemRequestDto;
import com.challenge.saleservice.resources.v1.dtos.SaleItemResponseDto;
import lombok.NonNull;
import lombok.var;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SaleItemMapper {
    public Optional<List<SaleItemResponseDto>> serializeListToDto(@NonNull final Optional<List<Item>> itens) {

        final var serializers = new ArrayList<SaleItemResponseDto>();

        itens.ifPresent(t -> t.forEach(address -> {
            serializers.add(serializeToDto(Optional.of(address)).get());
        }));

        return Optional.of(serializers);
    }

    public Optional<SaleItemResponseDto> serializeToDto(@NonNull final Optional<Item> itens) {
        final var dto = itens.get();

        return Optional.of(SaleItemResponseDto.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .createdAt(dto.getCreatedAt())
                .build());
    }

    public Optional<List<Item>> serializeListToModel(@NonNull final Optional<List<SaleItemRequestDto>> saleItemRequest) {

        final var models = new ArrayList<Item>();

        saleItemRequest.ifPresent(t -> t.forEach(address -> {
            models.add(serializeToModel(Optional.of(address)).get());
        }));

        return Optional.of(models);
    }

    public Optional<Item> serializeToModel(@NonNull final Optional<SaleItemRequestDto> saleItemRequest) {
        final var model = saleItemRequest.get();

        return Optional.of(Item.builder()
                .id(model.getId())
                .description(model.getDescription())
                .price(model.getPrice())
                .quantity(model.getQuantity())
                .createdAt(model.getCreatedAt())
                .build());
    }
}
