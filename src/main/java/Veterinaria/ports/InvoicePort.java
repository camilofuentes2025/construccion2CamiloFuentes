package Veterinaria.ports;

import Veterinaria.domain.models.Invoice;

public interface InvoicePort {
	
    boolean existInvoice(long invoiceID); 
    void saveInvoice(Invoice invoice); 
    Invoice findByInvoiceID(long invoiceID); 
    
}