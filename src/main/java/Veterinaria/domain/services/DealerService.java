package Veterinaria.domain.services;

import Veterinaria.domain.models.Order;
import Veterinaria.ports.OrderPort;

public class DealerService {
    OrderPort orderPort;

    public void consultOrder(Order order){
        if (orderPort.existOrder(order.getOrderID()) ){
            orderPort.showOrder(order);
        }else{
            System.out.println("No existe un factura relacionada con esa id");
        }
    }

    public void 

}
