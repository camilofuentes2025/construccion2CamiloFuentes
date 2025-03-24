package Veterinaria.ports;

import Veterinaria.domain.models.invoice;

public interface InvoicePort {
    boolean existInvoice(long invoiceID);
    void saveInvoice(invoice invoice);



}
