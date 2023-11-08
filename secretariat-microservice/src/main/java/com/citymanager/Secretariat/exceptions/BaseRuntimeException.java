package com.citymanager.Secretariat.exceptions;

import java.util.Map;

import com.citymanager.Secretariat.exceptions.contract.MessageException;

public abstract class BaseRuntimeException extends RuntimeException implements MessageException {

	private static final long serialVersionUID = 1L;

	private final Map<String, Object> mapDetails;

    public BaseRuntimeException() {
        mapDetails = null;
    }
    
    public BaseRuntimeException(final Map<String, Object> mapDetails) {
        this.mapDetails = mapDetails;
    }

    public abstract String getExceptionKey();

    public Map<String, Object> getMapDetails() {
        return this.mapDetails;
    }
}

