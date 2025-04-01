package Veterinaria.adapters.invoices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Veterinaria.adapters.invoices.entity.InvoiceEntity;
import Veterinaria.adapters.invoices.repository.InvoiceRepository;
import Veterinaria.adapters.orders.entity.OrderEntity;
import Veterinaria.adapters.persons.entity.PersonEntity;
import Veterinaria.adapters.pets.entity.PetEntity;
import Veterinaria.adapters.users.entity.UserEntity;
import Veterinaria.domain.models.Invoice;
import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;
import Veterinaria.domain.models.Person;
import Veterinaria.ports.InvoicePort;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceAdapter implements InvoicePort {

    @Autowired
    private InvoiceRepository invoiceRepository;
    
    @Override
    public boolean existInvoice(long invoiceID) {
        return invoiceRepository.existsByInvoiceID(invoiceID);
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        InvoiceEntity invoiceEntity = convertToInvoiceEntity(invoice);
        invoiceRepository.save(invoiceEntity);
        invoice.setInvoiceID(invoiceEntity.getInvoiceID());
    }

    @Override
    public Invoice findInvoiceByID(long invoiceID) {
        return invoiceRepository.findById(invoiceID)
                .map(this::convertToInvoice)
                .orElseThrow(() -> new IllegalArgumentException("Factura no encontrada con ID: " + invoiceID));
    }

    @Override
    public List<Invoice> findInvoicesByDate(Date date) {
        return invoiceRepository.findByDateCreated(date).stream()
                .map(this::convertToInvoice)
                .collect(Collectors.toList());
    }

    @Override
    public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll().stream()
                .map(this::convertToInvoice)
                .collect(Collectors.toList());
    }

    
    private Invoice convertToInvoice(InvoiceEntity entity) {
        if (entity == null) return null;

        Invoice invoice = new Invoice();
        invoice.setInvoiceID(entity.getInvoiceID());
        invoice.setPet(convertToPet(entity.getPet())); 
        invoice.setOwner(convertToPerson(entity.getOwner())); 
        invoice.setOrder(convertToOrder(entity.getOrder())); 
        invoice.setMedicine(entity.getMedicine());
        invoice.setPrice(entity.getPrice());
        invoice.setAmount(entity.getAmount());
        invoice.setDateCreated(entity.getDateCreated());
        return invoice;
    }

    private InvoiceEntity convertToInvoiceEntity(Invoice invoice) {
        InvoiceEntity entity = new InvoiceEntity();
        entity.setInvoiceID(invoice.getInvoiceID());
        entity.setPet(convertToPetEntity(invoice.getPet())); 
        entity.setOwner(convertToPersonEntity(invoice.getOwner())); 
        entity.setOrder(convertToOrderEntity(invoice.getOrder()));
        entity.setMedicine(invoice.getMedicine());
        entity.setPrice(invoice.getPrice());
        entity.setAmount(invoice.getAmount());
        entity.setDateCreated(invoice.getDateCreated());
        return entity;
    }
     
    private Pet convertToPet(PetEntity petEntity) {
        if (petEntity == null) return null;

        Pet pet = new Pet();
        pet.setPetName(petEntity.getPetName());
        pet.setOwner(convertToPerson(petEntity.getOwner()));
        pet.setAge(petEntity.getAge());
        pet.setPetID(petEntity.getPetID());
        pet.setAnimalSpecies(petEntity.getAnimalSpecies());
        pet.setAnimalBreed(petEntity.getAnimalBreed());
        pet.setCharacteristics(petEntity.getCharacteristics());
        pet.setWeight(petEntity.getWeight());
        return pet;
    }
    
    private PetEntity convertToPetEntity(Pet pet) {
        if (pet == null) return null; 

        PetEntity entity = new PetEntity();
        entity.setPetID(pet.getPetID());
        entity.setPetName(pet.getPetName());
        entity.setOwner(convertToPersonEntity(pet.getOwner())); 
        entity.setAge(pet.getAge());
        entity.setAnimalSpecies(pet.getAnimalSpecies());
        entity.setAnimalBreed(pet.getAnimalBreed());
        entity.setCharacteristics(pet.getCharacteristics());
        entity.setWeight(pet.getWeight());
        return entity; 
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
        if (person == null) {
            throw new IllegalArgumentException("La persona no puede ser nula.");
        }

        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(person.getId());
        personEntity.setName(person.getName());
        personEntity.setAge(person.getAge());
        personEntity.setRole(person.getRole());
        return personEntity;
    }
    
    private Order convertToOrder(OrderEntity entity) {
        if (entity == null) return null; 

        Order order = new Order();
        order.setOrderID(entity.getOrderID());
        order.setPet(convertToPet(entity.getPet())); 
        order.setOwner(convertToPerson(entity.getPetOwner())); 
        order.setVeterinarian(convertToUser(entity.getVeterinarian())); 
        order.setMedicine(entity.getClinicalRecord());
        order.setDateCreated(entity.getDate());
        return order; 
        
    }
    
    private OrderEntity convertToOrderEntity(Order order) {
        if (order == null) return null; 

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderID(order.getOrderID());
        orderEntity.setPet(convertToPetEntity(order.getPet()));
        orderEntity.setPetOwner(convertToPersonEntity(order.getOwner()));
        orderEntity.setVeterinarian(convertToUserEntity(order.getVeterinarian()));
        orderEntity.setClinicalRecord(order.getMedicine()); 
        orderEntity.setDate(order.getDateCreated()); 

        return orderEntity;
        
    }
    
   

    private User convertToUser(UserEntity userEntity) {
    	return null;
    }

    private UserEntity convertToUserEntity(User user) {
    	return null;
    }
    
    
}