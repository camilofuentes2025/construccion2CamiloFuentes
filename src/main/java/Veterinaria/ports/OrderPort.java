package Veterinaria.ports;

import Veterinaria.domain.models.Order;
import java.util.List;

public interface OrderPort {
	
    boolean existOrder(long orderID);
    void saveOrder(Order order);
    Order findByOrderID(long orderID);
    List<Order> findAllOrders();

}
