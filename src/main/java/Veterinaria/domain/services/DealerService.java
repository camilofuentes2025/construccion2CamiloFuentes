package Veterinaria.domain.services;


import Veterinaria.domain.models.invoice;
import Veterinaria.ports.InvoicePort;
import Veterinaria.ports.OrderPort;

public class DealerService {
    OrderPort orderPort;
    InvoicePort invoicePort;
    

    public void consultOrder(long order){
        if (orderPort.existOrder(order) ){
            orderPort.showOrder(orderPort.findByOrderID(order));
        }else{
            System.out.println("No existe un factura relacionada con esa id");
        }
    }

    public void register_sale(invoice invoice)throws Exception {

    if (invoicePort.existInvoice(invoice.getInvoiceID())) {
        throw new Exception("la factura ya existe");
    }
    if (!orderPort.existOrder(invoice.getOrder().getOrderID())) {
        throw new Exception("La factura no esta asocidada a ninguna orden existente");
    }

    invoicePort.saveInvoice(invoice);

    }

}
