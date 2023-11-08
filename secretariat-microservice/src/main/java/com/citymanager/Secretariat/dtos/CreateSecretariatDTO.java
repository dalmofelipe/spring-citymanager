package com.citymanager.Secretariat.dtos;

import com.citymanager.Secretariat.entities.SecretariatEntity;
import com.citymanager.Secretariat.enums.FolderEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateSecretariatDTO {

    // validation.properties
    @NotNull(message = "O campo 'folder' é obrigatório")
    private FolderEnum folder;

    @NotBlank(message = "Preencha o nome do secratário!")
    @NotNull(message = "O campo 'secretary' é obrigatório")
    private String secretary;

    @NotNull(message = "O campo 'populationGrade' é obrigatório")
    @Range(min = 0, max = 100, message = "{population.grade.range.validation}")
    private Float populationGrade;

    private Boolean underInvestigation;

    public CreateSecretariatDTO() {
        this.underInvestigation = false;
    }

    public SecretariatEntity toEntity() {
        SecretariatEntity secretariat = new SecretariatEntity();
        BeanUtils.copyProperties(this, secretariat);
        return secretariat;
    }
}
