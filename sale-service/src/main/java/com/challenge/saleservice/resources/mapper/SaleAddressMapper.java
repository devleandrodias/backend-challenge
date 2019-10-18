package com.challenge.saleservice.resources.mapper;

import com.challenge.saleservice.model.Address;
import com.challenge.saleservice.resources.v1.dtos.SaleAddressRequestDto;
import com.challenge.saleservice.resources.v1.dtos.SaleAddressResponseDto;
import lombok.NonNull;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SaleAddressMapper {
    @Autowired
    private SaleMapper saleMapper;

    public Optional<List<SaleAddressResponseDto>> serializeListToDto(@NonNull final Optional<List<Address>> addresses) {

        final var serializers = new ArrayList<SaleAddressResponseDto>();

        addresses.ifPresent(t -> t.forEach(address -> {
            serializers.add(serializeToDto(Optional.of(address)).get());
        }));

        return Optional.of(serializers);
    }

    public Optional<SaleAddressResponseDto> serializeToDto(@NonNull final Optional<Address> address) {
        final var dto = address.get();

        return Optional.of(SaleAddressResponseDto.builder()
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

    public Optional<List<Address>> serializeListToModel(@NonNull final Optional<List<SaleAddressRequestDto>> saleAddressRequest) {

        final var models = new ArrayList<Address>();

        saleAddressRequest.ifPresent(t -> t.forEach(address -> {
            models.add(serializeToModel(Optional.of(address)).get());
        }));

        return Optional.of(models);
    }

    public Optional<Address> serializeToModel(@NonNull final Optional<SaleAddressRequestDto> saleAddressRequest) {
        final var model = saleAddressRequest.get();

        return Optional.of(Address.builder()
                .id(model.getId())
                .street(model.getStreet())
                .number(model.getNumber())
                .complement(model.getComplement())
                .zipcode(model.getZipcode())
                .neighborhood(model.getNeighborhood())
                .city(model.getCity())
                .uf(model.getUf())
                .build());
    }
}
