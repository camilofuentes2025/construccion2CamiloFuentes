package Veterinaria.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Veterinaria.domain.models.Invoice;
import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.ClinicalRecord;
import Veterinaria.ports.InvoicePort;
import Veterinaria.ports.OrderPort;

import java.sql.Date;
import java.util.List;

@Service
public class DealerService {

    @Autowired
    private OrderPort orderPort;

    @Autowired
    private InvoicePort invoicePort;


    public Order consultOrder(long orderId) throws Exception {
        if (!orderPort.existOrder(orderId)) {
            throw new Exception("No existe una orden asociada con el ID: " + orderId);
        }
        return orderPort.findByOrderID(orderId);
    }


    public void registerSale(Invoice invoice) throws Exception {
        if (invoicePort.existInvoice(invoice.getInvoiceID())) {
            throw new Exception("Error: La factura con ID " + invoice.getInvoiceID() + " ya existe.");
        }
        if (invoice.getOrder() == null || !orderPort.existOrder(invoice.getOrder().getOrderID())) {
            throw new Exception("Error: La factura no está asociada a ninguna orden existente.");
        }

        invoicePort.saveInvoice(invoice); // Guarda la factura con la orden vinculada
    }


    public List<Order> listOrders() {
        return orderPort.findAllOrders();
    }

}