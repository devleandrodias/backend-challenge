package com.challenge.storeservice.resources.v1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StoreAddressRequestDto {
    @Valid
    private Integer id;

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

    @Valid
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
}
