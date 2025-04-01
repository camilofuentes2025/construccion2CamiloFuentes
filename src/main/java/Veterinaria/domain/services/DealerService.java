package Veterinaria.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Veterinaria.domain.models.Invoice;
import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.ClinicalRecord;
import Veterinaria.ports.InvoicePort;
import Veterinaria.ports.OrderPort;

import java.sql.Date;

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

    public void register_sale(Invoice invoice)throws Exception {

    if (invoicePort.existInvoice(invoice.getInvoiceID())) {
        throw new Exception("la factura ya existe");
    }
    if (!orderPort.existOrder(invoice.getOrder().getOrderID())) {
        throw new Exception("La factura no esta asocidada a ninguna orden existente");
    }

    invoicePort.saveInvoice(invoice);

    }

}
/*   
    // Registrar una venta de medicamentos basada en ClinicalRecord
    public Invoice registerMedicationSale(ClinicalRecord clinicalRecord) throws Exception {
        // Validar que la orden asociada al ClinicalRecord exista y no esté anulada
        Order order = clinicalRecord.getOrderID();
        if (order == null || !orderPort.existOrder(order.getOrderID())) {
            throw new Exception("La orden no existe o no es válida.");
        }

        if (clinicalRecord.isOrderCanceled()) {
            throw new Exception("La orden asociada a este registro clínico ha sido anulada.");
        }

        // Generar la factura
        Invoice invoice = new Invoice();
        invoice.setInvoiceID(System.currentTimeMillis()); // Generar un ID único
        invoice.setOrder(order);
        invoice.setPet(order.getPet());
        invoice.setOwner(order.getOwner());
        invoice.setMedicine(clinicalRecord.getMedication()); // Medicamento
        invoice.setDosage(clinicalRecord.getDosage()); // Dosificación
        invoice.setPrice(5000); // Precio de ejemplo (puedes ajustar según lógica de precios)
        invoice.setAmount(1); // Unidades
        invoice.setDate(new Date(System.currentTimeMillis())); // Fecha actual

        // Registrar la factura
        invoicePort.saveInvoice(invoice);

        return invoice;
    }

    // Registrar una venta genérica (productos no relacionados con medicamentos)
    public Invoice registerGenericSale(String productName, int price, int quantity) throws Exception {
        // Validar información del producto
        if (productName == null || productName.isEmpty() || price <= 0 || quantity <= 0) {
            throw new Exception("El nombre del producto, el precio o la cantidad no son válidos.");
        }

        // Generar la factura
        Invoice invoice = new Invoice();
        invoice.setInvoiceID(System.currentTimeMillis()); // Generar un ID único
        invoice.setMedicine(productName); // Nombre del producto
        invoice.setPrice(price);
        invoice.setAmount(quantity);
        invoice.setDate(new Date(System.currentTimeMillis())); // Fecha actual

        // Registrar la factura
        invoicePort.saveInvoice(invoice);

        return invoice;
    }
}*/
