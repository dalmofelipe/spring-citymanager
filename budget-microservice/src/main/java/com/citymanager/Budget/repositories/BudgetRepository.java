package com.citymanager.Budget.repositories;

import com.citymanager.Budget.entities.BudgetEntity;
import com.citymanager.Budget.enums.FolderEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<BudgetEntity, Long> {

    List<BudgetEntity> findByPossibleDestinationsIn(List<FolderEnum> destinations);
}
