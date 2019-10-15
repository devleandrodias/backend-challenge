package com.challenge.storeservice.resources.mapper;

import com.challenge.storeservice.model.Store;
import com.challenge.storeservice.resources.v1.dtos.StoreRequestDto;
import com.challenge.storeservice.resources.v1.dtos.StoreResponseDto;
import lombok.NonNull;
import lombok.var;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StoreMapper {
    public Optional<List<StoreResponseDto>> serializeListToDto(@NonNull final Optional<List<Store>> stores) {

        final var serializers = new ArrayList<StoreResponseDto>();

        stores.ifPresent(t -> t.forEach(store -> {
            serializers.add(serializeToDto(Optional.of(store)).get());
        }));

        return Optional.of(serializers);
    }

    public Optional<StoreResponseDto> serializeToDto(@NonNull final Optional<Store> store) {
        final var model = store.get();

        return Optional.of(StoreResponseDto.builder()
                .id(model.getId())
                .name(model.getName())
                .createdAt(model.getCreatedAt())
                .build());
    }

    public Optional<Store> serializeToModel(@NonNull final Optional<StoreRequestDto> store) {
        final var dto = store.get();

        return Optional.of(Store.builder()
                .id(dto.getId())
                .name(dto.getName())
                .createdAt(dto.getCreatedAt())
                .build());
    }
}
