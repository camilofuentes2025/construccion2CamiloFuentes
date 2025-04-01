package Veterinaria.domain.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.List;

import Veterinaria.adapters.clinicalrecord.entity.ClinicalRecordEntity;
import Veterinaria.adapters.orders.entity.OrderEntity;
import Veterinaria.adapters.orders.repository.OrderRepository;
import Veterinaria.domain.models.ClinicalRecord;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;
import Veterinaria.ports.ClinicalRecordPort;
import Veterinaria.ports.OrderPort;
import Veterinaria.ports.PetPort;
import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.Person;

public class VeterinarianService {
    PetPort petPort;
    ClinicalRecordPort clinicalRecordPort;
    OrderPort orderPort;

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

    public void getClinicalHistoryByPet(long petId) throws Exception {
        List<ClinicalRecord> records = clinicalRecordPort.findByPet_Id(petId);
        if (records.isEmpty()) {
            new Exception("❌ No hay historial clínico para la mascota con ID: " + petId);
        } else {
            records.forEach(System.out::println);
        }
    }

    public void cancelOrderFromClinicalHistory(Long orderId)throws Exception{
    // Buscar la orden
    Order order = orderPort.findByOrderID(orderId)
    if (order==null) {
        new Exception("No existe una orden registrada con ese Id");
    }
    // Registrar la anulación en la historia clínica
    ClinicalRecord record = new ClinicalRecord();
    record.setPet(order.getPet());
    record.setVeterinarian(order.getVeterinarian());
    record.setDate(LocalDate.now());
    record.setConsultationReason("Anulación de orden médica");
    record.setProcedureDetails("Se ha registrado la anulación de la orden con ID " + orderId + ".");
    record.setOrderCanceled(true);
    clinicalRecordPort.saveClinicalRecord(record);

}
public Order createOrder(User veterinarian, Pet pet, Person owner, String medicine) {
        // Validar que los datos sean correctos
        if (veterinarian == null || pet == null || owner == null || medicine == null || medicine.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios para crear una orden.");
        }

        // Crear nueva orden
        Order order = new Order();
        order.setVeterinarian(veterinarian);
        order.setPet(pet);
        order.setOwner(owner);
        order.setMedicine(medicine);
        order.setDateCreated(new Date());

        // Guardar usando el puerto
        orderPort.saveOrder(order);
        
        return order;
    }

    public Order consultOrder(long orderId) throws Exception {
	       
        if (!orderPort.existOrder(orderId)) {
            throw new Exception("No existe una orden asociada con el ID: " + orderId);
        }

        return orderPort.findByOrderID(orderId);
    }


    



}
