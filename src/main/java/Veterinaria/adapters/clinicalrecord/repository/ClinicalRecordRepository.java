package Veterinaria.adapters.clinicalrecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Veterinaria.adapters.clinicalrecord.entity.ClinicalRecordEntity;

import java.sql.Date;
import java.util.List;

public interface ClinicalRecordRepository extends JpaRepository<ClinicalRecordEntity, Long> {
    boolean existsByHistoryID(long historyID); 
    ClinicalRecordEntity findByHistoryID(long historyID); 
    List<ClinicalRecordEntity> findByVeterinarian_Id(long veterinarianID); 
    List<ClinicalRecordEntity> findByDate(Date date); 
    List<ClinicalRecordEntity> findByPet_Id(long petId);
}