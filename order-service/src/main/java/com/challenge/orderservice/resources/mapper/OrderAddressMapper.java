package com.challenge.orderservice.resources.mapper;

import com.challenge.orderservice.model.Address;
import com.challenge.orderservice.resources.v1.dtos.OrderAddressRequestDto;
import com.challenge.orderservice.resources.v1.dtos.OrderAddressResponseDto;
import lombok.NonNull;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderAddressMapper {
    @Autowired
    private OrderMapper orderMapper;

    public Optional<List<OrderAddressResponseDto>> serializeListToDto(@NonNull final Optional<List<Address>> addresses) {

        final var serializers = new ArrayList<OrderAddressResponseDto>();

        addresses.ifPresent(t -> t.forEach(address -> {
            serializers.add(serializeToDto(Optional.of(address)).get());
        }));

        return Optional.of(serializers);
    }

    public Optional<OrderAddressResponseDto> serializeToDto(@NonNull final Optional<Address> address) {
        final var dto = address.get();

        return Optional.of(OrderAddressResponseDto.builder()
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

    public Optional<List<Address>> serializeListToModel(@NonNull final Optional<List<OrderAddressRequestDto>> orderAddressRequest) {

        final var models = new ArrayList<Address>();

        orderAddressRequest.ifPresent(t -> t.forEach(address -> {
            models.add(serializeToModel(Optional.of(address)).get());
        }));

        return Optional.of(models);
    }

    public Optional<Address> serializeToModel(@NonNull final Optional<OrderAddressRequestDto> orderAddressRequest) {
        final var model = orderAddressRequest.get();

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
