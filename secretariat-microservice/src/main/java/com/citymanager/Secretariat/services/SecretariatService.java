package com.citymanager.Secretariat.services;

import com.citymanager.Secretariat.dtos.CreateSecretariatDTO;
import com.citymanager.Secretariat.dtos.InvertigatedDTO;
import com.citymanager.Secretariat.entities.SecretariatEntity;
import com.citymanager.Secretariat.enums.FolderEnum;
import com.citymanager.Secretariat.exceptions.business.SecretariatAlreadyExistsException;
import com.citymanager.Secretariat.exceptions.business.SecretariatNotFoundException;
import com.citymanager.Secretariat.repositories.SecretariatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecretariatService {

    private SecretariatRepository secretariatRepository;

    public SecretariatService(SecretariatRepository secretariatRepository) {
        this.secretariatRepository = secretariatRepository;
    }

    public SecretariatEntity create(CreateSecretariatDTO createSecretariatDto) {

        FolderEnum folder = createSecretariatDto.getFolder();
        SecretariatEntity secretariat = secretariatRepository.findByFolder(folder);

        if(secretariat != null) throw new SecretariatAlreadyExistsException(folder.getValue());

        return secretariatRepository.save(createSecretariatDto.toEntity());
    }

    public List<SecretariatEntity> findAll() {
        return secretariatRepository.findAll();
    }

    public SecretariatEntity findById(Long id) {

        Optional<SecretariatEntity> secretariatOpt = secretariatRepository.findById(id);

        if(secretariatOpt.isEmpty()) throw new SecretariatNotFoundException();

        return secretariatOpt.get();
    }

    public void changeInvestigation(InvertigatedDTO invertigatedDTO, Long id) {

        Optional<SecretariatEntity> secretariatOpt = secretariatRepository.findById(id);

        if(secretariatOpt.isEmpty()) throw new SecretariatNotFoundException();

        Boolean investigated = invertigatedDTO.getUnderInvestigation();
        SecretariatEntity secretariat = secretariatOpt.get();

        secretariat.setUnderInvestigation(investigated);

        secretariatRepository.save(secretariat);
    }
    
}
