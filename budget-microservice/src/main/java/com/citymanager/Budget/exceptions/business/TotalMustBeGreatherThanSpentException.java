package com.citymanager.Budget.exceptions.business;

import com.citymanager.Budget.exceptions.BaseRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class TotalMustBeGreatherThanSpentException extends BaseRuntimeException {

    private static final String KEY = "total.gt.spent";

    public TotalMustBeGreatherThanSpentException() {
        super();
    }

    @Override
    public String getExceptionKey() {
        return KEY;
    }
}
