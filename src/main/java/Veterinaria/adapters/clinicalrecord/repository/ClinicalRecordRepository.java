package Veterinaria.adapters.clinicalrecord.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import Veterinaria.adapters.clinicalrecord.entity.ClinicalRecordEntity;
import Veterinaria.adapters.pets.entity.PetEntity;

public interface ClinicalRecordRepository extends JpaRepository<ClinicalRecordEntity, Long> {

    boolean existsByHistoryID(long historyID);
    ClinicalRecordEntity findByHistoryID(long historyID);
    List<ClinicalRecordEntity> findByPet(PetEntity pet);
    
}