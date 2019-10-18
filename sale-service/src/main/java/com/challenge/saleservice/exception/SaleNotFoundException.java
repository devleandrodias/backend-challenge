package com.challenge.saleservice.exception;

import com.challenge.saleservice.exception.handler.BaseHandlerException;

public class SaleNotFoundException extends BaseHandlerException {
    public SaleNotFoundException(Object... parameters) {
        super(parameters);
    }
}
