package Veterinaria.ports;

import Veterinaria.domain.models.Invoice;
import java.sql.Date;
import java.util.List;

public interface InvoicePort {
	boolean existInvoice(long InvoiceID);
    void saveInvoice(Invoice invoice); // Guarda una factura
    Invoice findInvoiceByID(long invoiceID); // Busca una factura por su ID
    List<Invoice> findInvoicesByDate(Date date); // Encuentra facturas por fecha
    List<Invoice> findAllInvoices(); // Lista todas las facturas
}