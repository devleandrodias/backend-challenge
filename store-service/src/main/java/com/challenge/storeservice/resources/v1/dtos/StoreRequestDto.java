package com.challenge.storeservice.resources.v1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
}
