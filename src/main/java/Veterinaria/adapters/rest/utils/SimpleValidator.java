package Veterinaria.adapters.rest.utils;

import java.time.LocalDate;


import org.springframework.stereotype.Component;

import Veterinaria.Exceptions.InputsException;
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
	
	 public String stringValidator(String value, String element) throws Exception {
	        if (value == null || value.trim().isEmpty()) {
	            throw new InputsException(element + " no tiene un valor válido");
	        }
	        return value.trim();
	    }

	    public Long longValidator(String value, String element) throws Exception {
	        try {
	            return Long.parseLong(stringValidator(value, element));
	        } catch (NumberFormatException e) {
	            throw new InputsException(element + " debe ser un valor numérico entero");
	        }
	    }

	    public Integer intValidator(String value, String element) throws Exception {
	        try {
	            return Integer.parseInt(stringValidator(value, element));
	        } catch (NumberFormatException e) {
	            throw new InputsException(element + " debe ser un valor numérico entero");
	        }
	    }

	    public Double doubleValidator(String value, String element) throws Exception {
	        try {
	            return Double.parseDouble(stringValidator(value, element));
	        } catch (NumberFormatException e) {
	            throw new InputsException(element + " debe ser un valor numérico decimal");
	        }
	    }
	    
	    public Boolean booleanValidator(String value, String element) throws Exception {
	        String normalizedValue = stringValidator(value, element).toLowerCase();
	        
	        if (normalizedValue.equals("true") || normalizedValue.equals("false")) {
	            return Boolean.parseBoolean(normalizedValue);
	        } else {
	            throw new InputsException(element + " debe ser 'true' o 'false'.");
	        }
	    }
	    
}

