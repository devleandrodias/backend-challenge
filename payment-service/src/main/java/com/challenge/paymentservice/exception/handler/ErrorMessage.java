package com.challenge.paymentservice.exception.handler;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class ErrorMessage {
    private String developerMessage;
    private String userMessage;
    private int errorCode;
}
