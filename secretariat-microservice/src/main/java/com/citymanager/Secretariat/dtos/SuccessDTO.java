package com.citymanager.Secretariat.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SuccessDTO {

    @NotBlank
    private String message;
}
