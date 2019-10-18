package com.challenge.saleservice.resources.v1.dtos;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SaleAddressRequestDto {
    @Valid
    private Integer id;

    @Valid
    @NotNull
    private Integer sale_id;

    @Valid
    @NotNull
    private String street;

    @Valid
    @NotNull
    private String number;

    @Valid
    @NotNull
    private String complement;

    @Valid
    @NotNull
    private String zipcode;

    @Valid
    @NotNull
    private String neighborhood;

    @Valid
    @NotNull
    private String city;

    @Valid
    @NotNull
    private String uf;
}
