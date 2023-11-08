package com.citymanager.Budget.exceptions.business;

import com.citymanager.Budget.exceptions.BaseRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class BudgetNotFoundException extends BaseRuntimeException {

    private static final String KEY = "budget.not.found";

    public BudgetNotFoundException() {
        super();
    }

    @Override
    public String getExceptionKey() {
        return KEY;
    }
}
