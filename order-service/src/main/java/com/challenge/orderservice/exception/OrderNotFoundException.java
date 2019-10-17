package com.challenge.orderservice.exception;

import com.challenge.orderservice.exception.handler.BaseHandlerException;

public class OrderNotFoundException extends BaseHandlerException {
    public OrderNotFoundException(Object... parameters) {
        super(parameters);
    }
}