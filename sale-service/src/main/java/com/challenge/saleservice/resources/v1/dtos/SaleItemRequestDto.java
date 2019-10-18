package com.challenge.saleservice.resources.v1.dtos;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SaleItemRequestDto {
    @Valid
    private Integer id;

    @Valid
    @NotNull
    private String description;

    @Valid
    @NotNull
    private BigDecimal price;

    @Valid
    @NotNull
    private Integer quantity;
}
