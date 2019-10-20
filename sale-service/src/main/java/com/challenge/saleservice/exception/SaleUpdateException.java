package com.challenge.saleservice.exception;

import com.challenge.saleservice.exception.handler.BaseHandlerException;

public class SaleUpdateException extends BaseHandlerException {
    public SaleUpdateException(Object... parameters) {
        super(parameters);
    }
}
