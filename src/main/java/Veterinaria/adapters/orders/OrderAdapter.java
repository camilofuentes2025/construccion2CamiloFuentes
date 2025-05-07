package Veterinaria.adapters.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Veterinaria.adapters.orders.entity.OrderEntity;
import Veterinaria.adapters.orders.repository.OrderRepository;
import Veterinaria.adapters.persons.entity.PersonEntity;
import Veterinaria.adapters.pets.entity.PetEntity;
import Veterinaria.adapters.users.entity.UserEntity;
import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;
import Veterinaria.ports.OrderPort;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderAdapter implements OrderPort {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean existOrder(long orderID) {
        return orderRepository.existsByOrderID(orderID);
    }

    @Override
    public void saveOrder(Order order) {
        if (order == null || order.getPet() == null || order.getOwner() == null || order.getVeterinarian() == null) {
            throw new IllegalArgumentException("La orden, mascota, dueño y veterinario no pueden ser nulos.");
        }
        OrderEntity orderEntity = convertToOrderEntity(order);
        orderRepository.save(orderEntity);
        order.setOrderID(orderEntity.getOrderID());
    }

    @Override
    public Order findByOrderID(long orderID) {
        OrderEntity orderEntity = orderRepository.findByOrderID(orderID);
        if (orderEntity == null) {
            throw new IllegalArgumentException("La orden con ID " + orderID + " no existe.");
        }
        return convertToOrder(orderEntity);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::convertToOrder)
                .collect(Collectors.toList());
    }

    private Order convertToOrder(OrderEntity orderEntity) {
        if (orderEntity == null) return null;

        Order order = new Order();
        order.setOrderID(orderEntity.getOrderID());
        order.setPet(convertToPet(orderEntity.getPet()));
        order.setOwner(convertToPerson(orderEntity.getPerson()));
        order.setVeterinarian(convertToUser(orderEntity.getUser()));
        order.setMedicine(orderEntity.getMedicine());
        order.setDate(orderEntity.getDate());
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

    private Pet convertToPet(PetEntity petEntity) {
        if (petEntity == null) return null;

        Pet pet = new Pet();
        pet.setPetName(petEntity.getPetName());
        pet.setOwner(convertToPerson(petEntity.getPerson()));
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

    private UserEntity convertToUserEntity(User user) {
        if (user == null) return null;

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setPerson(convertToPersonEntity(user));
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        return userEntity;
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