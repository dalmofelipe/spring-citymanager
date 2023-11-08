package com.citymanager.Secretariat.repositories;

import com.citymanager.Secretariat.entities.SecretariatEntity;

import com.citymanager.Secretariat.enums.FolderEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretariatRepository extends JpaRepository<SecretariatEntity, Long> {

    SecretariatEntity findByFolder(FolderEnum folder);
}
