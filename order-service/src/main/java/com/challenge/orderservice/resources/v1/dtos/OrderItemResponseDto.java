package com.challenge.orderservice.resources.v1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderItemResponseDto {
    private Integer id;
    private String description;
    private Number unitPrice;
    private Integer quantity;
    private OrderResponseDto order;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date createdAt;
}
