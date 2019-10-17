package com.challenge.orderservice.resources.v1.dtos;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderItemRequestDto {
    @Valid
    private Integer id;

    @Valid
    @NotNull
    private String description;

    @Valid
    @NotNull
    private Number unitPrice;

    @Valid
    @NotNull
    private Integer quantity;
}
