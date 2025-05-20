package Veterinaria.adapters.rest.utils;

import org.springframework.stereotype.Component;

import Veterinaria.domain.models.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Setter
@Getter
@NoArgsConstructor

public class PetValidator extends SimpleValidator {
	
	public String petNameValidator(String value) throws Exception {
		return stringValidator(value, "nombre de la mascota ");
	}
	
	public Person ownerValidator(Person owner) throws Exception {
	        if (owner == null) {
	            throw new Exception("El dueño de la mascota no puede ser nulo.");
	        }
	        return owner;
	    }
	
	public long ageValidator(String value)throws Exception {
		return longValidator(value, " numero de años ");
	}
	 
	public long petIDValidator(String value)throws Exception {
		return longValidator(value, " numero de id de la mascota ");
	}
	
	public String animalSpeciesValidator(String value) throws Exception {
		return stringValidator(value, " especie de la mascota ");
	}
	
	public String animalBreedValidator(String value) throws Exception {
		return stringValidator(value, " raza de la mascota ");
	}
	
	public String characteristicsValidator(String value) throws Exception {
		return stringValidator(value, " caracteristicas de la mascota ");
	}
	
	public long weightValidator(String value)throws Exception {
		return longValidator(value, " peso de la mascota ");
	}
}
