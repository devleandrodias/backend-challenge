package com.challenge.paymentservice.exception;

import com.challenge.paymentservice.exception.handler.BaseHandlerException;

public class PaymentNotFoundException extends BaseHandlerException {
    public PaymentNotFoundException(Object... parameters) {
        super(parameters);
    }
}