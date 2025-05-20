package Veterinaria.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Veterinaria.Exceptions.BusinessException;
import Veterinaria.Exceptions.InputsException;

import Veterinaria.adapters.rest.request.PetRequest;
import Veterinaria.adapters.rest.request.UserRequest;
import Veterinaria.adapters.rest.utils.PersonValidator;
import Veterinaria.adapters.rest.utils.UserValidator;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;
import Veterinaria.domain.services.AdminService;
import Veterinaria.domain.services.DealerService;
import Veterinaria.domain.services.VeterinarianService;


@RestController

public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private PersonValidator personValidator;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/")
	public String itsAlive() {
		return "i'm alive";
	}
	
	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
	
	@PostMapping("/dealer")
	public ResponseEntity createDealer(@RequestBody UserRequest request){
		try {
		System.out.println(request.toString());
		User user = new User();
		
		user.setName(personValidator.nameValidator(request.getName()));
        user.setRole(AdminService.ROLE_DEALER); 
        user.setUsername(userValidator.usernameValidator(request.getUsername()));
        user.setPassword(userValidator.passwordValidator(request.getPassword()));
        if (request.getId() <= 0) { 
            throw new InputsException("El número de documento debe ser mayor que cero.");
        }
        user.setId(request.getId());
		
		adminService.registerDealer(user);
		return new ResponseEntity("se ha creado el vendedor",HttpStatus.OK);
		}catch(BusinessException be) {
			return new ResponseEntity(be.getMessage(),HttpStatus.CONFLICT);
		}catch(InputsException ie) {
			return new ResponseEntity(ie.getMessage(),HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }	
	
	@PostMapping("/veterinarian")
	public ResponseEntity<String> createVeterinarian(@RequestBody UserRequest request) {
	    try {
	        System.out.println(request.toString());

	        // Crear usuario con validaciones
	        User user = new User();
	        user.setName(personValidator.nameValidator(request.getName()));
	        user.setRole(AdminService.ROLE_VETERINARIAN); // Rol fijo
	        user.setUsername(userValidator.usernameValidator(request.getUsername()));
	        user.setPassword(userValidator.passwordValidator(request.getPassword()));

	        if (request.getId() <= 0) { // Validación mejorada
	            throw new InputsException("El número de documento debe ser mayor que cero.");
	        }
	        user.setId(request.getId());

	        // Registrar veterinario
	        adminService.registerVeterinarian(user);

	        return new ResponseEntity<>("Se ha creado el veterinario", HttpStatus.OK);
	    } catch (BusinessException be) {
	        return new ResponseEntity<>(be.getMessage(), HttpStatus.CONFLICT);
	    } catch (InputsException ie) {
	        return new ResponseEntity<>(ie.getMessage(), HttpStatus.BAD_REQUEST);
	    } catch (Exception e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}


        


