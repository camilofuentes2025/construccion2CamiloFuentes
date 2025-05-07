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
    public Invoice findByInvoiceID(long invoiceID) {
        return invoiceRepository.findById(invoiceID)
                .map(this::convertToInvoice)
                .orElseThrow(() -> new IllegalArgumentException("Factura no encontrada con ID: " + invoiceID));
    }


   
    /*public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll().stream()
                .map(this::convertToInvoice)
                .collect(Collectors.toList());
    }
*/
    
    private Invoice convertToInvoice(InvoiceEntity entity) {
        if (entity == null) return null;

        Invoice invoice = new Invoice();
        invoice.setInvoiceID(entity.getInvoiceID());
        invoice.setPet(convertToPet(entity.getPet())); 
        invoice.setOwner(convertToPerson(entity.getPerson())); 
        invoice.setOrder(convertToOrder(entity.getOrder())); 
        invoice.setMedicine(entity.getMedicine());
        invoice.setPrice(entity.getPrice());
        invoice.setAmount(entity.getAmount());
        invoice.setDate(entity.getDate());
        return invoice;
    }

    private InvoiceEntity convertToInvoiceEntity(Invoice invoice) {
        InvoiceEntity entity = new InvoiceEntity();
        entity.setInvoiceID(invoice.getInvoiceID());
        entity.setPet(convertToPetEntity(invoice.getPet())); 
        entity.setPerson(convertToPersonEntity(invoice.getOwner())); 
        entity.setOrder(convertToOrderEntity(invoice.getOrder()));
        entity.setMedicine(invoice.getMedicine());
        entity.setPrice(invoice.getPrice());
        entity.setAmount(invoice.getAmount());
        entity.setDate(invoice.getDate());
        return entity;
    }
     
    private Pet convertToPet(PetEntity petEntity) {
        if (petEntity == null) return null;

        Pet pet = new Pet();
        pet.setPetName(petEntity.getPetName());
        pet.setOwner(convertToPerson(petEntity.getPerson()));  // Debes obtener la entidad Person
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

        PetEntity petEntity = new PetEntity();
        petEntity.setPetName(pet.getPetName());
        petEntity.setPerson(convertToPersonEntity(pet.getOwner()));
        petEntity.setAge(pet.getAge());
        petEntity.setPetID(pet.getPetID());
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
        order.setOwner(convertToPerson(entity.getPerson())); 
        order.setVeterinarian(convertToUser(entity.getUser())); 
        order.setMedicine(entity.getMedicine());
        order.setDate(entity.getDate());
        return order; 
        
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
    
   

    private User convertToUser(UserEntity userEntity) {
        if (userEntity == null) return null;

        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword()); // Considera si necesitas transformar contraseñas encriptadas.
        return user;
    }

    private UserEntity convertToUserEntity(User user) {
        if (user == null) return null;

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }
    
    
}