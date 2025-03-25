package Veterinaria.ports;

import Veterinaria.domain.models.ClinicalRecord;
import java.sql.Date;
import java.util.List;

public interface ClinicalRecordPort {
   
    boolean existClinicalRecord(long historyID);
    void saveClinicalRecord(ClinicalRecord record);
    ClinicalRecord findByHistoryID(long historyID);
    List<ClinicalRecord> findAllClinicalRecords();
    void updateClinicalRecord(ClinicalRecord record);
    List<ClinicalRecord> findByVeterinarian(long veterinarianID);
    List<ClinicalRecord> findByDate(Date date);
}