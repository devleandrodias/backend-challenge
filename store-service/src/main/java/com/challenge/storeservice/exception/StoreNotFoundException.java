package com.challenge.storeservice.exception;

import com.challenge.storeservice.exception.handler.BaseHandlerException;

public class StoreNotFoundException extends BaseHandlerException {
    public StoreNotFoundException(Object... parameters) {
        super(parameters);
    }
}