package com.challenge.orderservice.exception.handler;

public class BaseHandlerException extends RuntimeException{
    private final Object[] parameters;

    public BaseHandlerException(final Object... parameters) {
        this.parameters = parameters;
    }

    public Object[] getParameters() {
        return this.parameters.clone();
    }
}