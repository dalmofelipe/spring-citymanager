package com.citymanager.Budget.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {

    @NotNull
    @Min(value = 1, message = "Valor deve ser positivo maior que zero!")
    private Float expense;
}
