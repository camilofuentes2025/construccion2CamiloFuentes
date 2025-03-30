package Veterinaria.domain.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import Veterinaria.adapters.clinicalrecord.entity.ClinicalRecordEntity;
import Veterinaria.adapters.orders.entity.OrderEntity;
import Veterinaria.domain.models.ClinicalRecord;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;
import Veterinaria.ports.ClinicalRecordPort;
import Veterinaria.ports.PetPort;
import Veterinaria.domain.models.Order;

public class VeterinarianService {
    PetPort petPort;
    ClinicalRecordPort clinicalRecordPort;



    public void consultMedicalhistory(long petID){
        


    }

    public void editMedicalHistory(long petID){


    }

    public void registerClinicalRecord(long historyID, User veterinarian, String consultationReason, 
                                       String symptoms, String diagnosis, String procedure, 
                                       String medication, String dosage, Order order, 
                                       String vaccinationHistory, String allergyMedications, 
                                       String procedureDetails, Pet pet) throws Exception {
        ClinicalRecord record = new ClinicalRecord();
        record.setHistoryID(historyID);
        record.setDate(new Date());
        record.setVeterinarian(veterinarian);
        record.setConsultationReason(consultationReason);
        record.setSymptoms(symptoms);
        record.setDiagnosis(diagnosis);
        record.setProcedure(procedure);
        record.setMedication(medication);
        record.setDosage(dosage);
        record.setOrder(order);
        record.setVaccinationHistory(vaccinationHistory);
        record.setAllergyMedications(allergyMedications);
        record.setProcedureDetails(procedureDetails);
        record.setOrderCanceled(false);
        record.setPet(pet);


        if (!petPort.existPet(record.getPet().getPetID())) {
            throw new Exception("La mascota no esta registrada en el sistema");
        }

        clinicalRecordPort.saveClinicalRecord(record);
        System.out.println("✅ Historia clínica registrada.");
    }

    public void getClinicalHistoryByPet(long petId) {
        List<ClinicalRecord> records = clinicalRecordPort.findByPet_Id(petId);
        if (records.isEmpty()) {
            System.out.println("❌ No hay historial clínico para la mascota con ID: " + petId);
        } else {
            records.forEach(System.out::println);
        }
    }

    public String cancelOrderFromClinicalHistory(Long orderId, Long veterinarianId) {
        // Buscar la orden
        Optional<OrderEntity> optionalOrder = orderRepository.findById(orderId);

        if (optionalOrder.isEmpty()) {
            return "❌ No existe la orden con ID " + orderId;
        }

        OrderEntity order = optionalOrder.get();

        // Verificar que el veterinario que intenta anularla sea el que la creó
        if (!order.getVeterinarian().getId().equals(veterinarianId)) {
            return "⛔ Solo el veterinario que creó la orden puede anularla.";
        }

        // Verificar si la orden ya fue cancelada
        if (order.isCanceled()) {
            return "⚠️ La orden con ID " + orderId + " ya estaba anulada.";
        }

        // Marcar la orden como cancelada
        order.setCanceled(true);
        orderRepository.save(order);

        // Registrar la anulación en la historia clínica
        ClinicalRecordEntity record = new ClinicalRecordEntity();
        record.setPet(order.getPet());
        record.setVeterinarian(order.getVeterinarian());
        record.setDateCreated(new Date(System.currentTimeMillis()));
        record.setConsultationReason("Anulación de orden médica");
        record.setProcedureDetails("La orden con ID " + orderId + " ha sido anulada.");
        record.setOrderCanceled(true);

        clinicalRecordRepository.save(record);

        return "✅ La orden " + orderId + " ha sido anulada correctamente y registrada en el historial clínico.";
    }





}
