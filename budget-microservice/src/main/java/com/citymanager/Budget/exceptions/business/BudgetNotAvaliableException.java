package com.citymanager.Budget.exceptions.business;

import com.citymanager.Budget.exceptions.BaseRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class BudgetNotAvaliableException extends BaseRuntimeException {

    private static final String KEY = "budget.not.avaliable";

    public BudgetNotAvaliableException(Float value) {
        super(Map.of("value", value));
    }

    @Override
    public String getExceptionKey() {
        return KEY;
    }
}
