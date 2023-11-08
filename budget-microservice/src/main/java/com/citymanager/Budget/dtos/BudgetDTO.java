package com.citymanager.Budget.dtos;

import com.citymanager.Budget.entities.BudgetEntity;
import com.citymanager.Budget.enums.FolderEnum;
import com.citymanager.Budget.enums.OriginEnum;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class BudgetDTO {

    @NotNull(message = "{total.amount.is.required}")
    @Min(value = 0, message = "{min.total.amount.value}")
    private Float totalAmount;

    @NotNull(message = "{spent.amount.is.required}")
    @Min(value = 0, message = "{min.spent.amount.value}")
    private Float spentAmount;

    @NotNull(message = "{possible.destinations.is.required}")
    private List<FolderEnum> possibleDestinations;

    @NotNull(message = "")
    private OriginEnum origin;

    public BudgetEntity toEntity() {
        BudgetEntity budgetEntity = new BudgetEntity();
        BeanUtils.copyProperties(this, budgetEntity);
        return budgetEntity;
    }

}
