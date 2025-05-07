package Veterinaria.adapters.inputs.utils;

import java.sql.Date;

import org.springframework.stereotype.Component;

import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Setter
@Getter
@NoArgsConstructor
public class OrderValidator extends SimpleValidator{

    public long orderIDValidator(String value) throws Exception {
    	return longValidator(value, "numero de ID de orden ");
    }

    public Pet petValidator(Pet pet) throws Exception {
        return petValidator(pet, "Mascota");
    }

    public Person ownerValidator(Person owner) throws Exception {
        return personValidator(owner, "Dueño de la mascota");
    }

    public User veterinarianValidator(User user) throws Exception {
    	return userValidator(user, " numero de ID de veterinario ");
    }

    public String medicineValidator(String value) throws Exception {
    	return stringValidator(value, "nombre de la medicina/producto ");
    }
    public Date dateCreatedValidator(String dateInput) throws Exception {
        return dateValidator(dateInput, "Fecha de creación de la orden");
    }


}