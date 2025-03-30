package Veterinaria.adapters.inputs.utils;

import org.springframework.stereotype.Component;

@Component
public class UserValidator extends SimpleValidator {

		public String usernameValidator(String value) throws Exception{
			return stringValidator(value, " nombre de usuario ");
		}
		
		public String passwordValidator(String value) throws Exception{
			return stringValidator(value, " contraseña de usuario ");
		}
}
