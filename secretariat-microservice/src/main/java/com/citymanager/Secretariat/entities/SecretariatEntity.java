package com.citymanager.Secretariat.entities;

import javax.persistence.*;

import com.citymanager.Secretariat.enums.FolderEnum;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_secretariat")
public class SecretariatEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FolderEnum folder;

    private String secretary;

    @Column(name = "poputation_grade")
    private Float populationGrade;

    @Column(name = "under_investigation")
    private Boolean underInvestigation;

    public SecretariatEntity() {
        this.underInvestigation = false;
    }
}
