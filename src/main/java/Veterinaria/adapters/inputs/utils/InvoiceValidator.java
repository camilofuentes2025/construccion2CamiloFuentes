package Veterinaria.adapters.inputs.utils;

import java.sql.Date;

import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;

public class InvoiceValidator extends SimpleValidator{

    public long invoiceIDValidator(String value) throws Exception {
    	return longValidator(value, "numero de ID de la factura ");
    }

    public Pet petValidator(Pet pet) throws Exception {
        return petValidator(pet, "Mascota");
    }

    public Person ownerValidator(Person owner) throws Exception {
        return personValidator(owner, "Dueño de la mascota");
    }
    
    public Order orderValidator(Order order) throws Exception {
    	return orderValidator(order, "numero de ID de orden ");
    }

    public String medicineValidator(String value) throws Exception {
    	return stringValidator(value, "nombre de la medicina/producto ");
    }
    
    public long priceValidator(String value) throws Exception {
    	return longValidator(value, " precio ");
    }
    
    public long amountValidator(String value) throws Exception {
    	return longValidator(value, " cantidad ");
    }
    
    public Date dateCreatedValidator(String dateInput) throws Exception {
        return dateValidator(dateInput, "Fecha de creación de la orden");
    }
    
}

