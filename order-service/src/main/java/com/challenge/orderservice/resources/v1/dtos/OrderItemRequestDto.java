package com.challenge.orderservice.resources.v1.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderItemRequestDto {
    private Integer id;
    private String description;
    private Number unitPrice;
    private Integer quantity;
    private OrderResponseDto order;
    private Date createdAt;
}
