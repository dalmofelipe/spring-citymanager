package com.citymanager.Secretariat.exceptions.business;

import com.citymanager.Secretariat.exceptions.BaseRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SecretariatNotFoundException extends BaseRuntimeException {

    private static final String KEY = "secretariat.not.found";

    public SecretariatNotFoundException() {
        super();
    }

    @Override
    public String getExceptionKey() {
        return KEY;
    }
}
