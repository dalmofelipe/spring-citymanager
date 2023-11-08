package com.citymanager.Budget.exceptions;

import com.citymanager.Budget.exceptions.contract.MessageException;

import java.util.Map;

public abstract class BaseRuntimeException extends RuntimeException implements MessageException {

    private final Map<String, Object> mapDetails;

    public BaseRuntimeException() {
        this.mapDetails = null;
    }

    public BaseRuntimeException(final Map<String, Object> mapDetails) {
        this.mapDetails = mapDetails;
    }

    @Override
    public Map<String, Object> getMapDetails() {
        return this.mapDetails;
    }
}
