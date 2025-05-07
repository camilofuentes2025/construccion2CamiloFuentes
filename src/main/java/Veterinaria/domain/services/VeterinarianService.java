package Veterinaria.domain.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Veterinaria.adapters.clinicalrecord.entity.ClinicalRecordEntity;
import Veterinaria.adapters.orders.entity.OrderEntity;
import Veterinaria.adapters.orders.repository.OrderRepository;
import Veterinaria.domain.models.ClinicalRecord;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;
import Veterinaria.ports.ClinicalRecordPort;
import Veterinaria.ports.OrderPort;
import Veterinaria.ports.PersonPort;
import Veterinaria.ports.PetPort;
import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.Person;

@Service
public class VeterinarianService {

    @Autowired
    private PetPort petPort;

    @Autowired
    private PersonPort personPort;

    @Autowired
    private ClinicalRecordPort clinicalRecordPort;

    @Autowired
    private OrderPort orderPort;

    public void registerPet(Pet pet) throws Exception {
        if (petPort.existPet(pet.getPetID())) {
            throw new Exception("Error: Ya existe una mascota registrada con el ID " + pet.getPetID());
        }
        petPort.savePet(pet);
    }

    public void registerOwner(Person owner) throws Exception {
        if (personPort.existPerson(owner.getId())) {
            throw new Exception("Error: Ya existe un dueño registrado con el ID " + owner.getId());
        }
        personPort.savePerson(owner);
    }

    public void registerClinicalRecord(ClinicalRecord record) throws Exception {
        if (record.getPetID() == null || !petPort.existPet(record.getPetID().getPetID())) {
            throw new Exception("Error: La mascota con ID " + (record.getPetID() != null ? record.getPetID().getPetID() : "null") + " no está registrada.");
        }
        clinicalRecordPort.saveClinicalRecord(record);
    }

 
    public List<ClinicalRecord> getClinicalHistoryByPet(Pet pet) throws Exception {
        List<ClinicalRecord> records = clinicalRecordPort.findByPetID(pet);
        if (records.isEmpty()) {
            throw new Exception("Error: No se encontró historia clínica para la mascota con ID " + pet);
        }
        return records;
    }


    public Order createOrder(Order order) throws Exception {
        if (!petPort.existPet(order.getPet().getPetID())) {
            throw new Exception("Error: La mascota con ID " + order.getPet().getPetID() + " no está registrada.");
        }
        orderPort.saveOrder(order);
        return order;
    }

 
    public void cancelOrder(Long orderId) throws Exception {
        Order order = orderPort.findByOrderID(orderId);
        if (order == null) {
            throw new Exception("Error: No existe una orden con ID " + orderId);
        }
        ClinicalRecord record = new ClinicalRecord();
        record.setPetID(order.getPet());
        record.setVeterinarian(order.getVeterinarian());
        record.setDate(new Date(System.currentTimeMillis()));
        record.setConsultationReason("Anulación de orden médica");
        record.setProcedureDetails("Orden con ID " + orderId + " anulada.");
        record.setOrderCanceled(true);
        clinicalRecordPort.saveClinicalRecord(record);
    }

    public Order getOrderById(long orderId) throws Exception {
        Order order = orderPort.findByOrderID(orderId);
        if (order == null) {
            throw new Exception("Error: No existe una orden con el ID " + orderId);
        }
        return order;
    }
}