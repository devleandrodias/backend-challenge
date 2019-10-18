package com.challenge.saleservice.resources.mapper;

import com.challenge.saleservice.model.Sale;
import com.challenge.saleservice.resources.v1.dtos.SaleRequestDto;
import com.challenge.saleservice.resources.v1.dtos.SaleResponseDto;
import lombok.NonNull;
import lombok.var;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SaleMapper {
    public Optional<List<SaleResponseDto>> serializeListToDto(@NonNull final Optional<List<Sale>> sales) {

        final var serializers = new ArrayList<SaleResponseDto>();

        sales.ifPresent(t -> t.forEach(sale -> {
            serializers.add(serializeToDto(Optional.of(sale)).get());
        }));

        return Optional.of(serializers);
    }

    public Optional<SaleResponseDto> serializeToDto(@NonNull final Optional<Sale> sale) {
        final var dto = sale.get();

        return Optional.of(SaleResponseDto.builder()
                .id(dto.getId())
                .confirmationDate(dto.getConfirmationDate())
                .createdAt(dto.getCreatedAt())
                .build());
    }

    public Optional<Sale> serializeToModel(@NonNull final Optional<SaleRequestDto> saleRequest) {
        final var model = saleRequest.get();

        return Optional.of(Sale.builder()
                .id(model.getId())
                .confirmationDate(model.getConfirmationDate())
                .build());
    }
}
