package com.challenge.storeservice.resources.v1.dtos;

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
public class StoreRequestDto {
    @Valid
    private Integer id;

    @Valid
    @NotNull
    private String name;

    @Valid
    @NotNull
    private List<StoreAddressRequestDto> address;

    @Valid
    @NotNull
    private Date createdAt;
}
