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

import java.sql.Date;
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
        OrderEntity orderEntity = convertToOrderEntity(order);
        orderRepository.save(orderEntity);
        order.setOrderID(orderEntity.getOrderID()); 
    }

    @Override
    public Order findByOrderID(long orderID) {
        OrderEntity orderEntity = orderRepository.findByOrderID(orderID)/*.orElse(null)*/;
        return convertToOrder(orderEntity);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::convertToOrder)
                .collect(Collectors.toList());
    }

    @Override
    public void showOrder(Order order) {
        if (order != null) {
            System.out.println("Detalles de la Orden:");
            System.out.println("ID: " + order.getOrderID());
            System.out.println("Mascota: " + (order.getPet() != null ? order.getPet().getPetName() : "Sin mascota asociada"));
            System.out.println("Dueño: " + (order.getOwner() != null ? order.getOwner().getName() : "Sin dueño asociado"));
            System.out.println("Veterinario: " + (order.getVeterinarian() != null ? order.getVeterinarian().getUsername() : "Sin veterinario asociado"));
            System.out.println("Medicamento: " + order.getMedicine());
            System.out.println("Fecha: " + order.getDateCreated());
        } else {
            System.out.println("La orden está vacía o no existe.");
        }
    }

    private Order convertToOrder(OrderEntity orderEntity) {
        if (orderEntity == null) return null;

        Order order = new Order();
        order.setOrderID(orderEntity.getOrderID());
        order.setPet(convertToPet(orderEntity.getPet()));
        order.setOwner(convertToPerson(orderEntity.getPetOwner()));
        order.setVeterinarian(convertToUser(orderEntity.getVeterinarian()));
        order.setMedicine(orderEntity.getClinicalRecord()); 
        order.setDateCreated(orderEntity.getDate()); 

        return order;
    }

    private OrderEntity convertToOrderEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderID(order.getOrderID());
        orderEntity.setPet(convertToPetEntity(order.getPet()));
        orderEntity.setPetOwner(convertToPersonEntity(order.getOwner()));
        orderEntity.setVeterinarian(convertToUserEntity(order.getVeterinarian()));
        orderEntity.setClinicalRecord(order.getMedicine()); 
        orderEntity.setDate(order.getDateCreated()); 

        return orderEntity;
    }

    private Pet convertToPet(PetEntity petEntity) {
        return null;
    }

    private PetEntity convertToPetEntity(Pet pet) {
        return null;
    }

    private Person convertToPerson(PersonEntity personEntity) {
        return null;
    }

    private PersonEntity convertToPersonEntity(Person person) {
        return null;
    }

    private User convertToUser(UserEntity userEntity) {
        return null;
    }

    private UserEntity convertToUserEntity(User user) {
        return null;
    }
}
/*package Veterinaria.adapters.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Veterinaria.adapters.orders.entity.OrderEntity;
import Veterinaria.adapters.orders.repository.OrderRepository;
import Veterinaria.domain.models.Order;
import Veterinaria.ports.OrderPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
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
        OrderEntity orderEntity = convertToOrderEntity(order);
        orderRepository.save(orderEntity);
        order.setOrderID(orderEntity.getOrderID());
    }

    @Override
    public Order findByOrderID(long orderID) {
        OrderEntity orderEntity = orderRepository.findByOrderID(orderID).orElse(null);
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
        order.setPetOwner(convertToPerson(orderEntity.getPetOwner()));
        order.setVeterinarian(convertToUser(orderEntity.getVeterinarian()));
        order.setClinicalRecord(orderEntity.getClinicalRecord());
        order.setDate(orderEntity.getDate());
        return order;
    }

    private OrderEntity convertToOrderEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderID(order.getOrderID());
        orderEntity.setPet(convertToPetEntity(order.getPet()));
        orderEntity.setPetOwner(convertToPersonEntity(order.getPetOwner()));
        orderEntity.setVeterinarian(convertToUserEntity(order.getVeterinarian()));
        orderEntity.setClinicalRecord(order.getClinicalRecord());
        orderEntity.setDate(order.getDate());
        return orderEntity;
    }

    // Methods to convert Pet, Person, and User
    private Pet convertToPet(PetEntity petEntity) {
        // Implement conversion logic
    }

    private PetEntity convertToPetEntity(Pet pet) {
        // Implement conversion logic
    }

    private Person convertToPerson(PersonEntity personEntity) {
        // Implement conversion logic
    }

    private PersonEntity convertToPersonEntity(Person person) {
        // Implement conversion logic
    }

    private User convertToUser(UserEntity userEntity) {
        // Implement conversion logic
    }

    private UserEntity convertToUserEntity(User user) {
        // Implement conversion logic
    }
}
*/