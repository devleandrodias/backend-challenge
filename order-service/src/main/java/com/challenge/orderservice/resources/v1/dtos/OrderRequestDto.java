package com.challenge.orderservice.resources.v1.dtos;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderRequestDto {
    @Valid
    private Integer id;

    @Valid
    private Date confirmationDate;

    @Valid
    @NotNull
    private OrderAddressResponseDto address;

    @Valid
    @NotNull
    private List<OrderItemResponseDto> item;

    @Valid
    @NotNull
    private Date createdAt;
}
