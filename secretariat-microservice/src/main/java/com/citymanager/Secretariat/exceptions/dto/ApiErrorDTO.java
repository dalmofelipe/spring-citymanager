package com.citymanager.Secretariat.exceptions.dto;

import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorDTO {
	
	private Date timestamp;
    private Integer status;
    private String code;
    private Set<ErrorDTO> errors;
}
