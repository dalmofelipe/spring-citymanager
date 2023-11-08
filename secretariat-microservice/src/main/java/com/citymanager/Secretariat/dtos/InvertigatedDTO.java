package com.citymanager.Secretariat.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class InvertigatedDTO {

    @NotNull(message = "O campo 'underInvestigation' é obrigatório!")
    private Boolean underInvestigation;
}
