package Veterinaria.ports;

import Veterinaria.domain.models.ClinicalRecord;
import Veterinaria.domain.models.Pet;

import java.util.List;

public interface ClinicalRecordPort {
	
	boolean existClinicalRecord(long historyID);
    void saveClinicalRecord(ClinicalRecord record); 
    ClinicalRecord findByHistoryID(long historyID);
    List<ClinicalRecord> findByPetID(Pet pet);
    
}