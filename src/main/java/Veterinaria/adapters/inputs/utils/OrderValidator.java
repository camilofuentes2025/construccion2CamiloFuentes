package Veterinaria.adapters.inputs.utils;

import java.sql.Date;

import org.springframework.stereotype.Component;

import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.User;

@Component
public class OrderValidator extends SimpleValidator{

    public long orderIDValidator(String value) throws Exception {
    	return longValidator(value, "numero de ID de orden ");
    }

    public Pet petIDValidator (String value) throws Exception {
    	return petValidator(value, " numero de ID de mascota ");
    }

    public Person ownerValidator(String value) throws Exception {
    	return personValidator(value, " numero de ID del dueño de la mascota ");
    }

    public User veterinarianValidator(String value) throws Exception {
    	return userValidator(value, " numero de ID de veterinario ");
    }

    public String medicineValidator(String value) throws Exception {
    	return stringValidator(value, "nombre de la medicina/producto ");
    }

}