package Veterinaria.adapters.rest.utils;

import java.sql.Date;

import org.springframework.stereotype.Component;

import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Setter
@Getter
@NoArgsConstructor
public class InvoiceValidator extends SimpleValidator{

    public long invoiceIDValidator(String value) throws Exception {
    	return longValidator(value, "numero de ID de la factura ");
    }

    public Pet petValidator(Pet pet) throws Exception {
        if (pet == null) {
            throw new Exception("La mascota no puede ser nula.");
        }
        return pet;
    }

    public Person ownerValidator(Person owner) throws Exception {
        if (owner == null) {
            throw new Exception("El dueño de la mascota no puede ser nulo.");
        }
        return owner;
    }
    
    public Order orderValidator(Order order) throws Exception {
        if (order == null) {
            throw new Exception("la orden no puede ser nulo.");
        }
        return order;
    }

    public String medicineValidator(String value) throws Exception {
    	return stringValidator(value, "nombre de la medicina/producto ");
    }
    
    public int priceValidator(int value) throws Exception {
        if (value <= 0) {
            throw new Exception("El precio debe ser mayor que cero.");
        }
        return value;
    }

public long amountValidator(long value) throws Exception {
    if (value <= 0) {
        throw new Exception("La cantidad debe ser mayor que cero.");
    }
    return value;
}

    
    public String dateCreatedValidator(String value) throws Exception {
        return stringValidator(value, "Fecha de creación de la orden");
    }
    
}

