package com.challenge.storeservice.resources.mapper;

import com.challenge.storeservice.model.Store;
import com.challenge.storeservice.resources.v1.dtos.StoreRequestDto;
import com.challenge.storeservice.resources.v1.dtos.StoreResponseDto;
import lombok.NonNull;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StoreMapper {
    @Autowired
    private StoreAddressMapper storeAddressMapper;

    public Optional<List<StoreResponseDto>> serializeListToDto(@NonNull final Optional<List<Store>> stores) {

        final var serializers = new ArrayList<StoreResponseDto>();

        stores.ifPresent(t -> t.forEach(store -> {
            serializers.add(serializeToDto(Optional.of(store)).get());
        }));

        return Optional.of(serializers);
    }

    public Optional<StoreResponseDto> serializeToDto(@NonNull final Optional<Store> store) {
        final var dto = store.get();

        final var address = storeAddressMapper.serializeListToDto(Optional.of(dto.getAddress()));

        return Optional.of(StoreResponseDto.builder()
                .id(dto.getId())
                .name(dto.getName())
                .address(address.get())
                .createdAt(dto.getCreatedAt())
                .build());
    }

    public Optional<Store> serializeToModel(@NonNull final Optional<StoreRequestDto> storeRequest) {
        final var model = storeRequest.get();

        final var address = storeAddressMapper.serializeListToModel(Optional.of(model.getAddress()));

        return Optional.of(Store.builder()
                .id(model.getId())
                .name(model.getName())
                .address(address.get())
                .build());
    }
}
