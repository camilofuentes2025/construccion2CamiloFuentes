package Veterinaria.adapters.invoices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Veterinaria.adapters.invoices.entity.InvoiceEntity;
import Veterinaria.adapters.orders.entity.OrderEntity;

import java.sql.Date;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
	boolean existsByInvoiceID(long invoiceID);
    InvoiceEntity findByInvoiceID(long invoiceID);
    List<InvoiceEntity> findByDateCreated(Date date); 
}