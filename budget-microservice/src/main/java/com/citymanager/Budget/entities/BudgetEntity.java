package com.citymanager.Budget.entities;

import com.citymanager.Budget.enums.FolderEnum;
import com.citymanager.Budget.enums.OriginEnum;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "tb_budget")
public class BudgetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "budget_id")
    private Long id;

    @Column(name = "total_amount")
    private Float totalAmount;

    @Column(name = "spent_amount")
    private Float spentAmount;

    @ElementCollection(targetClass = FolderEnum.class)
    @JoinTable(name = "tb_folders", joinColumns = @JoinColumn(name = "budget_id"))
    @Column(name = "possible_destinations", nullable = true)
    @Enumerated(EnumType.STRING)
    Collection<FolderEnum> possibleDestinations;

    @Enumerated(EnumType.STRING)
    private OriginEnum origin;

}
