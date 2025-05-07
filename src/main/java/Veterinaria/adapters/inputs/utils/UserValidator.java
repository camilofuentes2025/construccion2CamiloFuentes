package Veterinaria.adapters.inputs.utils;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Setter
@Getter
@NoArgsConstructor
public class UserValidator extends SimpleValidator {

		public String usernameValidator(String value) throws Exception{
			return stringValidator(value, " nombre de usuario ");
		}
		
		public String passwordValidator(String value) throws Exception{
			return stringValidator(value, " contraseña de usuario ");
		}
		
		public String credentialsValidator(String value) throws Exception{
			return stringValidator(value, " credenciales incorrectas ");
		}
		
		
}
