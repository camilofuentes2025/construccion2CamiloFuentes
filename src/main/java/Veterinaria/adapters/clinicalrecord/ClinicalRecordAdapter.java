package Veterinaria.adapters.clinicalrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Veterinaria.adapters.clinicalrecord.entity.ClinicalRecordEntity;
import Veterinaria.adapters.clinicalrecord.repository.ClinicalRecordRepository;
import Veterinaria.adapters.users.entity.UserEntity;
import Veterinaria.domain.models.ClinicalRecord;
import Veterinaria.domain.models.User;
import Veterinaria.ports.ClinicalRecordPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@Service
public class ClinicalRecordAdapter implements ClinicalRecordPort {
    @Autowired
    private ClinicalRecordRepository clinicalRecordRepository;

    @Override
    public boolean existClinicalRecord(long historyID) {
        return clinicalRecordRepository.existsByHistoryID(historyID);
    }

    @Override
    public void saveClinicalRecord(ClinicalRecord record) {
        ClinicalRecordEntity recordEntity = convertToClinicalRecordEntity(record);
        clinicalRecordRepository.save(recordEntity);
        record.setHistoryID(recordEntity.getHistoryID());
    }

    @Override
    public ClinicalRecord findByHistoryID(long historyID) {
        ClinicalRecordEntity recordEntity = clinicalRecordRepository.findByHistoryID(historyID).orElse(null);
        return convertToClinicalRecord(recordEntity);
    }

    @Override
    public List<ClinicalRecord> findAllClinicalRecords() {
        return clinicalRecordRepository.findAll().stream()
                .map(this::convertToClinicalRecord)
                .collect(Collectors.toList());
    }

    private ClinicalRecord convertToClinicalRecord(ClinicalRecordEntity recordEntity) {
        if (recordEntity == null) return null;

        ClinicalRecord record = new ClinicalRecord();
        record.setHistoryID(recordEntity.getHistoryID());
        record.setDate(recordEntity.getDate());
        record.setVeterinarian(convertToUser(recordEntity.getVeterinarian()));
        record.setConsultationReason(recordEntity.getConsultationReason());
        record.setSymptoms(recordEntity.getSymptoms());
        record.setDiagnosis(recordEntity.getDiagnosis());
        record.setProcedure(recordEntity.getProcedure());
        record.setMedication(recordEntity.getMedication());
        record.setDosage(recordEntity.getDosage());
        record.setOrderID(recordEntity.getOrderID());//crear un metodo para convertir del order entity a order del modelo
        record.setVaccinationHistory(recordEntity.getVaccinationHistory());
        record.setAllergyMedications(recordEntity.getAllergyMedications());
        record.setProcedureDetails(recordEntity.getProcedureDetails());
        record.setOrderCanceled(recordEntity.isOrderCanceled());
        return record;
    }

    private ClinicalRecordEntity convertToClinicalRecordEntity(ClinicalRecord record) {
        ClinicalRecordEntity recordEntity = new ClinicalRecordEntity();
        recordEntity.setHistoryID(record.getHistoryID());
        recordEntity.setDate(record.getDate());
        recordEntity.setVeterinarian(convertToUserEntity(record.getVeterinarian()));
        recordEntity.setConsultationReason(record.getConsultationReason());
        recordEntity.setSymptoms(record.getSymptoms());
        recordEntity.setDiagnosis(record.getDiagnosis());
        recordEntity.setProcedure(record.getProcedure());
        recordEntity.setMedication(record.getMedication());
        recordEntity.setDosage(record.getDosage());
        recordEntity.setOrderID(record.getOrderID());
        recordEntity.setVaccinationHistory(record.getVaccinationHistory());
        recordEntity.setAllergyMedications(record.getAllergyMedications());
        recordEntity.setProcedureDetails(record.getProcedureDetails());
        recordEntity.setOrderCanceled(record.isOrderCanceled());  
        return recordEntity;
    }

    // Métodos para convertir User
    private User convertToUser(UserEntity userEntity) {
        // Implementar lógica de conversión
    	return null;
    }

    private UserEntity convertToUserEntity(User user) {
        // Implementar lógica de conversión
    	return null;
    }
}
