package com.challenge.saleservice.resources.v1.dtos;

import com.challenge.saleservice.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    private Status status;

    private List<SaleAddressResponseDto> address;

    private List<SaleItemResponseDto> item;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date createdAt;
}
