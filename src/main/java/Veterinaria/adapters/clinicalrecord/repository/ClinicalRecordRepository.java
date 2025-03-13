package Veterinaria.adapters.clinicalrecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Veterinaria.adapters.clinicalrecord.entity.ClinicalRecordEntity;

public interface ClinicalRecordRepository extends JpaRepository<ClinicalRecordEntity, Long> {
    boolean existsByHistoryID(long historyID);
    ClinicalRecordEntity findByHistoryID(long historyID);
}
