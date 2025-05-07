package Veterinaria.adapters.invoices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Veterinaria.adapters.invoices.entity.InvoiceEntity;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {

    boolean existsByInvoiceID(long invoiceID);
    InvoiceEntity findByInvoiceID(long invoiceID);
    
}