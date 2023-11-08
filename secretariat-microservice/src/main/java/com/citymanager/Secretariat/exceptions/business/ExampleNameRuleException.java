package com.citymanager.Secretariat.exceptions.business;

import com.citymanager.Secretariat.exceptions.BaseRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExampleNameRuleException extends BaseRuntimeException {

    private static final String KEY = "example.name.rule";

    public ExampleNameRuleException() {
        super();
    }

    @Override
    public String getExceptionKey() {
        return KEY;
    }
}
