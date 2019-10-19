package com.challenge.paymentservice.resources.v1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.challenge.paymentservice.model.enums.Status;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PaymentRequestDto {
    @Valid
    private Integer id;

    @Valid
    @NotNull
    private String creditCardNumber;

    @Valid
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @Valid
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
}
