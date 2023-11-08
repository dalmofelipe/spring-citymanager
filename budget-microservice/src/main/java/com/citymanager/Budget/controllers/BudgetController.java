package com.citymanager.Budget.controllers;

import com.citymanager.Budget.dtos.BudgetDTO;
import com.citymanager.Budget.dtos.ExpenseDTO;
import com.citymanager.Budget.entities.BudgetEntity;
import com.citymanager.Budget.enums.FolderEnum;
import com.citymanager.Budget.services.BudgetService;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Budgets")
@RestController
@RequestMapping("/budgets")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    // Cria um orçamento validando todos os campos não nulos e brancos.
    @PostMapping
    public BudgetEntity create(@Validated @RequestBody BudgetDTO budgetDTO) {
        return budgetService.create(budgetDTO);
    }
    
    @GetMapping("/{id}")
    public BudgetEntity getBudget(@PathVariable Long id) {
    	return budgetService.getBudget(id);
    }

    // Lista todos os recursos disponíveis. É possível filtrar por possibleDestinations;
    // /budgets?destinations=SPORTS,EDUCATION
    @GetMapping
    public List<BudgetEntity> listBudgets(@RequestParam(value = "destinations", required = false) List<FolderEnum> destinations) {

        if(destinations == null) {
            return budgetService.listBudgets();
        }

        return budgetService.listBudgets(destinations);
    }

    // Registra um uso daquele orçamento (acrescenta no spentAmount caso seja menor do que a diferença (total - spent).
    @PatchMapping("/{id}/expense")
    public void registerExpense(@Valid @RequestBody ExpenseDTO expenseDTO, @PathVariable Long id) {
        budgetService.registerExpense(id, expenseDTO);
    }

}
