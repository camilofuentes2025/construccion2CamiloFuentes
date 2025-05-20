package Veterinaria.adapters.rest.utils;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Setter
@Getter
@NoArgsConstructor
public class PersonValidator extends SimpleValidator {
	
	public String nameValidator(String value) throws Exception {
		return stringValidator(value, "nombre de la persona ");
	}
	
	public long idValidator(String value)throws Exception {
		return longValidator(value, " numero de id ");
	}
	
	public long ageValidator(String value)throws Exception {
		return longValidator(value, " numero de años ");
	}
	
	public String roleValidator(String value) throws Exception {
		return stringValidator(value, " rol de la persona ");
	}
}

