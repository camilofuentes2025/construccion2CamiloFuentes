package Veterinaria.adapters.clinicalrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Veterinaria.adapters.clinicalrecord.entity.ClinicalRecordEntity;
import Veterinaria.adapters.clinicalrecord.repository.ClinicalRecordRepository;
import Veterinaria.adapters.orders.entity.OrderEntity;
import Veterinaria.adapters.users.entity.UserEntity;
import Veterinaria.domain.models.ClinicalRecord;
import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.User;
import Veterinaria.ports.ClinicalRecordPort;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        if (record == null || record.getVeterinarian() == null || record.getDate() == null) {
            throw new IllegalArgumentException("El registro clínico, veterinario y fecha no pueden ser nulos.");
        }
        ClinicalRecordEntity recordEntity = toEntity(record);
        clinicalRecordRepository.save(recordEntity);
        record.setHistoryID(recordEntity.getHistoryID());
    }

    @Override
    public ClinicalRecord findByHistoryID(long historyID) {
        ClinicalRecordEntity recordEntity = clinicalRecordRepository.findByHistoryID(historyID);
        if (recordEntity == null) {
            throw new IllegalArgumentException("El registro clínico con ID " + historyID + " no existe.");
        }
        return toDomain(recordEntity);
    }

    @Override
    public List<ClinicalRecord> findAllClinicalRecords() {
        return clinicalRecordRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public void updateClinicalRecord(ClinicalRecord record) {
        if (!existClinicalRecord(record.getHistoryID())) {
            throw new IllegalArgumentException("Registro clínico no existe para actualizar.");
        }
        saveClinicalRecord(record);
    }

    public List<ClinicalRecord> findByVeterinarian(long veterinarianID) {
        return clinicalRecordRepository.findByVeterinarian_Id(veterinarianID).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<ClinicalRecord> findByDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        return clinicalRecordRepository.findByDate(date).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
   
    
    private ClinicalRecord toDomain(ClinicalRecordEntity recordEntity) {
        if (recordEntity == null) return null;

        ClinicalRecord record = new ClinicalRecord();
        record.setHistoryID(recordEntity.getHistoryID());
        record.setDate(recordEntity.getDate());
        record.setVeterinarian(toDomain(recordEntity.getVeterinarian()));
        record.setConsultationReason(recordEntity.getConsultationReason());
        record.setSymptoms(recordEntity.getSymptoms());
        record.setDiagnosis(recordEntity.getDiagnosis());
        record.setProcedure(recordEntity.getProcedure());
        record.setMedication(recordEntity.getMedication());
        record.setDosage(recordEntity.getDosage());
        record.setOrder(toDomain(recordEntity.getOrder()));
        record.setVaccinationHistory(recordEntity.getVaccinationHistory());
        record.setAllergyMedications(recordEntity.getAllergyMedications());
        record.setProcedureDetails(recordEntity.getProcedureDetails());
        record.setOrderCanceled(recordEntity.isOrderCanceled());
        return record;
    }

    private ClinicalRecordEntity toEntity(ClinicalRecord record) {
        if (record == null) return null;

        ClinicalRecordEntity recordEntity = new ClinicalRecordEntity();
        recordEntity.setHistoryID(record.getHistoryID());
        recordEntity.setDate(record.getDate());
        recordEntity.setVeterinarian(toEntity(record.getVeterinarian()));
        recordEntity.setConsultationReason(record.getConsultationReason());
        recordEntity.setSymptoms(record.getSymptoms());
        recordEntity.setDiagnosis(record.getDiagnosis());
        recordEntity.setProcedure(record.getProcedure());
        recordEntity.setMedication(record.getMedication());
        recordEntity.setDosage(record.getDosage());
        recordEntity.setOrder(record.getOrder() != null ? toEntity(record.getOrder()) : null);
        recordEntity.setVaccinationHistory(record.getVaccinationHistory());
        recordEntity.setAllergyMedications(record.getAllergyMedications());
        recordEntity.setProcedureDetails(record.getProcedureDetails());
        recordEntity.setOrderCanceled(record.isOrderCanceled());
        return recordEntity;
    }

    private User toDomain(UserEntity userEntity) {
        if (userEntity == null) return null;
        
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getUsername());
        
        return user;
    }

    private UserEntity toEntity(User user) {
        if (user == null) return null;
        
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getName());
        
        return userEntity;
    }

    private Order toDomain(OrderEntity orderEntity) {
        if (orderEntity == null) return null;
        
        Order order = new Order();
        order.setOrderID(orderEntity.getOrderID());
        
        return order;
    }

    private OrderEntity toEntity(Order order) {
        if (order == null) return null;
        
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderID(order.getOrderID());
        
        return orderEntity;
    }
}