package com.challenge.saleservice.resources.v1.dtos;

import com.challenge.saleservice.model.enums.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SaleAddressResponseDto {
    private Integer id;

    private String street;

    private String number;

    private String complement;

    private String zipcode;

    private String neighborhood;

    private String city;

    private String uf;

    @Enumerated(EnumType.STRING)
    private Type type;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date createdAt;
}
