package com.challenge.storeservice.resources.mapper;

import com.challenge.storeservice.model.Address;
import com.challenge.storeservice.model.Store;
import com.challenge.storeservice.resources.v1.dtos.StoreAddressRequestDto;
import com.challenge.storeservice.resources.v1.dtos.StoreAddressResponseDto;
import com.challenge.storeservice.resources.v1.dtos.StoreRequestDto;
import lombok.NonNull;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StoreAddressMapper {
    @Autowired
    private StoreMapper storeMapper;

    public Optional<List<StoreAddressResponseDto>> serializeListToDto(@NonNull final Optional<List<Address>> addresses) {

        final var serializers = new ArrayList<StoreAddressResponseDto>();

        addresses.ifPresent(t -> t.forEach(address -> {
            serializers.add(serializeToDto(Optional.of(address)).get());
        }));

        return Optional.of(serializers);
    }

    public Optional<StoreAddressResponseDto> serializeToDto(@NonNull final Optional<Address> address) {
        final var dto = address.get();

        return Optional.of(StoreAddressResponseDto.builder()
                .id(dto.getId())
                .street(dto.getStreet())
                .number(dto.getNumber())
                .complement(dto.getComplement())
                .zipcode(dto.getZipcode())
                .neighborhood(dto.getNeighborhood())
                .city(dto.getCity())
                .uf(dto.getUf())
                .createdAt(dto.getCreatedAt())
                .build());
    }

    public Optional<List<Address>> serializeListToModel(@NonNull final Optional<List<StoreAddressRequestDto>> storeAddressRequest) {

        final var models = new ArrayList<Address>();

        storeAddressRequest.ifPresent(t -> t.forEach(address -> {
            models.add(serializeToModel(Optional.of(address)).get());
        }));

        return Optional.of(models);
    }

    public Optional<Address> serializeToModel(@NonNull final Optional<StoreAddressRequestDto> storeAddressRequest) {
        final var model = storeAddressRequest.get();

        return Optional.of(Address.builder()
                .id(model.getId())
                .street(model.getStreet())
                .number(model.getNumber())
                .complement(model.getComplement())
                .zipcode(model.getZipcode())
                .neighborhood(model.getNeighborhood())
                .city(model.getCity())
                .uf(model.getUf())
                .createdAt(model.getCreatedAt())
                .build());
    }
}
