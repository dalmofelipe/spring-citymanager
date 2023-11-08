package com.citymanager.Secretariat.exceptions.business;

import com.citymanager.Secretariat.exceptions.BaseRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class SecretariatAlreadyExistsException extends BaseRuntimeException {

    private static final String KEY = "secretariat.already.exists";

    public SecretariatAlreadyExistsException(String value) {
        super(Map.of("value", value));
    }

    @Override
    public String getExceptionKey() {
        return KEY;
    }
}
