package com.challenge.paymentservice.resources.v1.dtos;

import com.challenge.paymentservice.model.enums.Status;
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
public class PaymentResponseDto {
    private Integer id;
    
    private String creditCardNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date createdAt;
}
