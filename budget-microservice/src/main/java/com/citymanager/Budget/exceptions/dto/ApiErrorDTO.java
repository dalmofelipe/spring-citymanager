package com.citymanager.Budget.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorDTO {

    private Date timestamp;
    private Integer status;
    private String code;
    private Set<ErrorDTO> errors;
}
