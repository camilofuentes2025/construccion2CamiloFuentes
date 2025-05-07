package Veterinaria.adapters.clinicalrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Veterinaria.adapters.clinicalrecord.entity.ClinicalRecordEntity;
import Veterinaria.adapters.clinicalrecord.repository.ClinicalRecordRepository;
import Veterinaria.adapters.orders.entity.OrderEntity;
import Veterinaria.adapters.persons.entity.PersonEntity;
import Veterinaria.adapters.pets.entity.PetEntity;
import Veterinaria.adapters.users.entity.UserEntity;
import Veterinaria.domain.models.ClinicalRecord;
import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;
import Veterinaria.ports.ClinicalRecordPort;

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
        if (record == null || record.getVeterinarian() == null) {
            throw new IllegalArgumentException("El registro clínico y el veterinario no pueden ser nulos.");
        }
        ClinicalRecordEntity recordEntity = convertToClinicalRecordEntity(record);
        clinicalRecordRepository.save(recordEntity);
        record.setHistoryID(recordEntity.getHistoryID());
    }

    @Override
    public ClinicalRecord findByHistoryID(long historyID) {
        ClinicalRecordEntity recordEntity = clinicalRecordRepository.findByHistoryID(historyID);
        return convertToClinicalRecord(recordEntity);
    }

    @Override
    public List<ClinicalRecord> findByPetID(Pet pet) {
    	PetEntity petEntity = petAdapter(pet);
        List<ClinicalRecordEntity> records = clinicalRecordRepository.findByPetID(petEntity);
        return records.stream()
                .map(this::convertToClinicalRecord)
                .collect(Collectors.toList());
    }
    

    private ClinicalRecord convertToClinicalRecord(ClinicalRecordEntity recordEntity) {
        if (recordEntity == null) return null;

        ClinicalRecord record = new ClinicalRecord();
        record.setHistoryID(recordEntity.getHistoryID());
        record.setDate(recordEntity.getDate());
        record.setVeterinarian(convertToUser(recordEntity.getUser()));
        record.setOrder(convertToOrder(recordEntity.getOrder()));
        record.setPetID(petAdapter(recordEntity.getPet()));
        record.setConsultationReason(recordEntity.getConsultationReason());
        record.setSymptoms(recordEntity.getSymptoms());
        record.setDiagnosis(recordEntity.getDiagnosis());
        record.setProcedure(recordEntity.getProcedure());
        record.setMedication(recordEntity.getMedication());
        record.setDosage(recordEntity.getDosage());
        record.setVaccinationHistory(recordEntity.getVaccinationHistory());
        record.setAllergyMedications(recordEntity.getAllergyMedications());
        record.setProcedureDetails(recordEntity.getProcedureDetails());
        record.setOrderCanceled(recordEntity.isOrderCanceled());
        return record;
    }

    private ClinicalRecordEntity convertToClinicalRecordEntity(ClinicalRecord record) {
        if (record == null) return null;

        ClinicalRecordEntity recordEntity = new ClinicalRecordEntity();
        recordEntity.setHistoryID(record.getHistoryID());
        recordEntity.setDate(record.getDate());
        recordEntity.setUser(convertToUserEntity(record.getVeterinarian()));
        recordEntity.setOrder(convertToOrderEntity(record.getOrder()));
        recordEntity.setPet(convertToPetEntity(record.getPetID()));
        recordEntity.setConsultationReason(record.getConsultationReason());
        recordEntity.setSymptoms(record.getSymptoms());
        recordEntity.setDiagnosis(record.getDiagnosis());
        recordEntity.setProcedure(record.getProcedure());
        recordEntity.setMedication(record.getMedication());
        recordEntity.setDosage(record.getDosage());
        recordEntity.setVaccinationHistory(record.getVaccinationHistory());
        recordEntity.setAllergyMedications(record.getAllergyMedications());
        recordEntity.setProcedureDetails(record.getProcedureDetails());
        recordEntity.setOrderCanceled(record.isOrderCanceled());
        return recordEntity;
    }
    
    private User convertToUser(UserEntity userEntity) {
        if (userEntity == null) return null;

        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getPerson().getName());
        user.setAge(userEntity.getPerson().getAge());
        user.setRole(userEntity.getPerson().getRole());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        return user;
    }

    private Order convertToOrder(OrderEntity orderEntity) {
        if (orderEntity == null) return null;

        Order order = new Order();
        order.setOrderID(orderEntity.getOrderID());
        order.setPet(petAdapter(orderEntity.getPet()));
        order.setOwner(convertToPerson(orderEntity.getPerson()));
        order.setVeterinarian(convertToUser(orderEntity.getUser()));
        order.setMedicine(orderEntity.getMedicine());
        order.setDate(orderEntity.getDate());
        return order;
    }

    private Pet petAdapter(PetEntity petEntity) {
        if (petEntity == null) return null;

        Pet pet = new Pet();
        pet.setPetID(petEntity.getPetID());
        pet.setPetName(petEntity.getPetName());
        pet.setAge(petEntity.getAge());
        pet.setOwner(convertToPerson(petEntity.getPerson()));
        pet.setAnimalSpecies(petEntity.getAnimalSpecies());
        pet.setAnimalBreed(petEntity.getAnimalBreed());
        pet.setCharacteristics(petEntity.getCharacteristics());
        pet.setWeight(petEntity.getWeight());
        return pet;
    }

    private PetEntity petAdapter(Pet pet) {
        if (pet == null) return null;

        PetEntity petEntity = new PetEntity();
        petEntity.setPetID(pet.getPetID());
        petEntity.setPetName(pet.getPetName());
        petEntity.setAge(pet.getAge());
        petEntity.setPerson(convertToPersonEntity(pet.getOwner()));
        petEntity.setAnimalSpecies(pet.getAnimalSpecies());
        petEntity.setAnimalBreed(pet.getAnimalBreed());
        petEntity.setCharacteristics(pet.getCharacteristics());
        petEntity.setWeight(pet.getWeight());
        return petEntity;
    }
    
    private UserEntity convertToUserEntity(User user) {
        if (user == null) return null;

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setPerson(convertToPersonEntity(user));
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }

    private OrderEntity convertToOrderEntity(Order order) {
        if (order == null) return null;

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderID(order.getOrderID());
        orderEntity.setPet(convertToPetEntity(order.getPet()));
        orderEntity.setPerson(convertToPersonEntity(order.getOwner()));
        orderEntity.setUser(convertToUserEntity(order.getVeterinarian()));
        orderEntity.setMedicine(order.getMedicine());
        orderEntity.setDate(order.getDate());
        return orderEntity;
    }

    private PetEntity convertToPetEntity(Pet pet) {
        if (pet == null) return null;

        PetEntity petEntity = new PetEntity();
        petEntity.setPetID(pet.getPetID());
        petEntity.setPetName(pet.getPetName());
        petEntity.setPerson(convertToPersonEntity(pet.getOwner()));
        petEntity.setAge(pet.getAge());
        petEntity.setAnimalSpecies(pet.getAnimalSpecies());
        petEntity.setAnimalBreed(pet.getAnimalBreed());
        petEntity.setCharacteristics(pet.getCharacteristics());
        petEntity.setWeight(pet.getWeight());
        return petEntity;
    }
    
    private Person convertToPerson(PersonEntity personEntity) {
        if (personEntity == null) return null;

        Person person = new Person();
        person.setId(personEntity.getId());
        person.setName(personEntity.getName());
        person.setAge(personEntity.getAge());
        person.setRole(personEntity.getRole());
        return person;
    }

    private PersonEntity convertToPersonEntity(Person person) {
        if (person == null) return null;

        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(person.getId());
        personEntity.setName(person.getName());
        personEntity.setAge(person.getAge());
        personEntity.setRole(person.getRole());
        return personEntity;
    }
}