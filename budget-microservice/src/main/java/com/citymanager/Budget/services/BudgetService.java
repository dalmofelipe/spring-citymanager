package com.citymanager.Budget.services;

import com.citymanager.Budget.dtos.BudgetDTO;
import com.citymanager.Budget.dtos.ExpenseDTO;
import com.citymanager.Budget.entities.BudgetEntity;
import com.citymanager.Budget.enums.FolderEnum;
import com.citymanager.Budget.exceptions.business.BudgetNotAvaliableException;
import com.citymanager.Budget.exceptions.business.BudgetNotFoundException;
import com.citymanager.Budget.exceptions.business.TotalMustBeGreatherThanSpentException;
import com.citymanager.Budget.repositories.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public BudgetEntity create(BudgetDTO budgetDTO) {

        BudgetEntity budget = budgetDTO.toEntity();

        Float total = budget.getTotalAmount();
        Float spent = budget.getSpentAmount();
        Float budgetAmount = total - spent;

        if(budgetAmount <= 0) throw new TotalMustBeGreatherThanSpentException();

        return budgetRepository.save(budget);
    }

    public List<BudgetEntity> listBudgets() {
        return budgetRepository.findAll();
    }

    public List<BudgetEntity> listBudgets(List<FolderEnum> destinations) {
        return budgetRepository.findByPossibleDestinationsIn(destinations);
    }

    public void registerExpense(Long id, ExpenseDTO expenseDTO) {

        BudgetEntity budget = getBudget(id);

        Float total = budget.getTotalAmount();
        Float spent = budget.getSpentAmount();
        Float expense = expenseDTO.getExpense();
        Float budgetAvaliable = total - spent;

        if(expense > budgetAvaliable) throw new BudgetNotAvaliableException(budgetAvaliable);

        spent += expense;
        budget.setSpentAmount(spent);

        budgetRepository.save(budget);
    }

	public BudgetEntity getBudget(Long id) {
		
		Optional<BudgetEntity> budgetOpt = budgetRepository.findById(id);

        if(budgetOpt.isEmpty())  throw new BudgetNotFoundException();
        
        return budgetOpt.get();
	}
}
