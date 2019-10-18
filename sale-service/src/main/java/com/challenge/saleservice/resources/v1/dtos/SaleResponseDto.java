package com.challenge.saleservice.resources.v1.dtos;

import com.challenge.saleservice.model.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SaleResponseDto {
    private Integer id;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date confirmationDate;
    private Address address;
    private List<SaleItemResponseDto> item;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date createdAt;
}
