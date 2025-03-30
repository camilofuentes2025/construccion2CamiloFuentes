package Veterinaria.adapters.inputs.utils;



public class PetValidator extends SimpleValidator {
	
	public String petNameValidator(String value) throws Exception {
		return stringValidator(value, "nombre de la mascota ");
	}
	
	public long petIDValidator(String value)throws Exception {
		return longValidator(value, " numero de id de la mascota ");
	}
}
