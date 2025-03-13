package Veterinaria.adapters.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Veterinaria.adapters.orders.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    boolean existsByOrderID(long orderID);
    OrderEntity findByOrderID(long orderID);
}
