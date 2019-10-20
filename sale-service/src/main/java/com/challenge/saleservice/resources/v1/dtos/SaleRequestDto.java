package com.challenge.saleservice.resources.v1.dtos;

import com.challenge.saleservice.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class SaleRequestDto {
    @Valid
    private Integer id;

    @Valid
    private Date confirmationDate;

    @Valid
    @Enumerated(EnumType.STRING)
    private Status status;

    @Valid
    @NotNull
    private List<SaleItemRequestDto> item;

    //@Valid
    //@NotNull
    //private List<SaleAddressRequestDto> address;

    @Valid
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
}
