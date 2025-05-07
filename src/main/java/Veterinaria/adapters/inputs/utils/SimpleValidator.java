package Veterinaria.adapters.inputs.utils;

import java.sql.Date;
import java.time.LocalDate;


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
public  class SimpleValidator {
	
	public String stringValidator(String value, String element)throws Exception {
		if (value== null||value.equals("")) {
			throw new Exception(element + " no tiene un valor valido");
		}
		return value;
	}
	
	public Long longValidator(String value, String element)throws Exception{
		try {
			return Long.parseLong(stringValidator(value, element));
		}catch(Exception e) {
			throw new Exception(element + " debe ser un valor numerico");
		}
	}
	
	public Boolean booleanValidator(String value, String element) throws Exception {
	    if (value == null || value.trim().isEmpty()) {
	        throw new Exception(element + " no puede ser nulo o vacío.");
	    }
	    if (!value.equalsIgnoreCase("true") && !value.equalsIgnoreCase("false")) {
	        throw new Exception(element + " debe ser 'true' o 'false'.");
	    }
	    return Boolean.parseBoolean(value.trim());
	}
	
	 public Pet petValidator(Pet pet, String element) throws Exception {
	        if (pet == null) {
	            throw new Exception(element + " no puede ser nulo.");
	        }
	        if (pet.getPetID() <= 0) {
	            throw new Exception(element + " tiene un ID inválido.");
	        }
	        if (pet.getPetName() == null || pet.getPetName().trim().isEmpty()) {
	            throw new Exception(element + " debe tener un nombre válido.");
	        }
	        if (pet.getOwner() == null || pet.getOwner().getId() <= 0) {
	            throw new Exception(element + " debe estar asociado a un dueño válido.");
	        }
	        return pet;
	    }
	 public Person personValidator(Person person, String element) throws Exception {
	        if (person == null) {
	            throw new Exception(element + " no puede ser nulo.");
	        }
	        if (person.getId() <= 0) {
	            throw new Exception(element + " tiene una cédula inválida.");
	        }
	        if (person.getName() == null || person.getName().trim().isEmpty()) {
	            throw new Exception(element + " debe tener un nombre válido.");
	        }
	        if (person.getAge() <= 0) {
	            throw new Exception(element + " debe tener una edad positiva.");
	        }
	        if (person.getRole() == null || person.getRole().trim().isEmpty()) {
	            throw new Exception(element + " debe tener un rol válido.");
	        }
	        return person;
	    }

	    // Valida un objeto User
	    public User userValidator(User user, String element) throws Exception {
	        if (user == null) {
	            throw new Exception(element + " no puede ser nulo.");
	        }
	        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
	            throw new Exception(element + " debe tener un nombre de usuario válido.");
	        }
	        if (user.getPassword() == null || user.getPassword().length() < 6) {
	            throw new Exception(element + " debe tener una contraseña válida con al menos 6 caracteres.");
	        }
	        if (user.getRole() == null || user.getRole().trim().isEmpty()) {
	            throw new Exception(element + " debe tener un rol válido.");
	        }
	        return user;
	    }
	   

	    public Date dateValidator(String dateInput, String element) throws Exception {
	        if (dateInput == null || dateInput.trim().isEmpty()) {
	            throw new Exception(element + " no puede ser nulo o vacío.");
	        }
	        try {
	            Date date = Date.valueOf(dateInput);
	            if (date.toLocalDate().isAfter(java.time.LocalDate.now())) {
	                throw new Exception(element + " no puede ser una fecha futura.");
	            }
	            return date;
	        } catch (IllegalArgumentException e) {
	            throw new Exception(element + " debe estar en el formato 'YYYY-MM-DD'.");
	        }
	    }
	    
	    public Order orderValidator(Order order, String element) throws Exception {
	        if (order == null) {
	            throw new Exception(element + " no puede ser nulo.");
	        }

	        
	        if (order.getOrderID() <= 0) {
	            throw new Exception(element + " debe tener un ID de orden válido.");
	        }

	        
	        Pet pet = order.getPet();
	        if (pet == null || pet.getPetID() <= 0) {
	            throw new Exception(element + " debe estar asociado a una mascota válida.");
	        }

	      
	        Person owner = order.getOwner();
	        if (owner == null || owner.getId() <= 0) {
	            throw new Exception(element + " debe estar asociado a un dueño válido.");
	        }

	       
	        User veterinarian = order.getVeterinarian();
	        if (veterinarian == null || veterinarian.getId() <= 0) {
	            throw new Exception(element + " debe estar asociado a un veterinario válido.");
	        }

	       
	        stringValidator(order.getMedicine(), "Nombre del medicamento");

	      
	        dateValidator(order.getDate().toString(), "Fecha de creación de la orden");

	        return order;
	    }
	    
	    public String credentialValidator(String value, String element) throws Exception {
	        if (value == null || value.trim().isEmpty()) {
	            throw new Exception(element + " no puede ser nulo o vacío.");
	        }
	        if (value.length() < 6) {
	            throw new Exception(element + " debe tener al menos 6 caracteres.");
	        }
	        if (!value.matches("[a-zA-Z0-9]*")) {
	            throw new Exception(element + " solo puede contener letras y números.");
	        }
	        return value.trim();
	    }


  
	


	
}

