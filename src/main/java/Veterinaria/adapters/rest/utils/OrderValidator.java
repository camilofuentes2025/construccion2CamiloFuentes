package Veterinaria.adapters.rest.utils;

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
        return longValidator(value, "Número de ID de orden");
    }

    // Validación de mascota sin tocar SimpleValidator
    public Pet petValidator(Pet pet) throws Exception {
        if (pet == null) {
            throw new Exception("La mascota no puede ser nula.");
        }
        return pet;
    }

    // Validación de dueño sin tocar SimpleValidator
    public Person ownerValidator(Person owner) throws Exception {
        if (owner == null) {
            throw new Exception("El dueño de la mascota no puede ser nulo.");
        }
        return owner;
    }

    // Validación de veterinario sin tocar SimpleValidator
    public User veterinarianValidator(User user) throws Exception {
        if (user == null) {
            throw new Exception("El veterinario no puede ser nulo.");
        }
        return user;
    }

    public String medicineValidator(String value) throws Exception {
        return stringValidator(value, "Nombre de la medicina/producto");
    }

    public String dateCreatedValidator(String value) throws Exception {
        return stringValidator(value, "Fecha de creación de la orden");
    }



}