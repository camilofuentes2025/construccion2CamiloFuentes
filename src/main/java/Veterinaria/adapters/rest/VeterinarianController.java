package Veterinaria.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Veterinaria.Exceptions.BusinessException;
import Veterinaria.Exceptions.InputsException;
import Veterinaria.adapters.rest.request.OrderRequest;
import Veterinaria.adapters.rest.request.PersonRequest;
import Veterinaria.adapters.rest.request.PetRequest;
import Veterinaria.adapters.rest.request.UserRequest;
import Veterinaria.adapters.rest.utils.InvoiceValidator;
import Veterinaria.adapters.rest.utils.OrderValidator;
import Veterinaria.adapters.rest.utils.PersonValidator;
import Veterinaria.adapters.rest.utils.PetValidator;
import Veterinaria.adapters.rest.utils.UserValidator;
import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;
import Veterinaria.domain.services.AdminService;
import Veterinaria.domain.services.DealerService;
import Veterinaria.domain.services.VeterinarianService;

@RestController
public class VeterinarianController {

	    @Autowired
	    private VeterinarianService veterinarianService;

	    @Autowired
	    private InvoiceValidator invoiceValidator;
	    
	    @Autowired
		private PersonValidator personValidator;
		
		@Autowired
		private UserValidator userValidator;
		
		@Autowired
		private PetValidator petValidator;
		
		@Autowired
		private OrderValidator orderValidator;
		
		@PostMapping("/pet")
	    public ResponseEntity<String> createPet(@RequestBody PetRequest request) {
	        try {
	            System.out.println("Solicitud recibida: " + request.toString());

	            // Validar que la mascota tenga datos correctos
	            if (request.getPetID() <= 0) {
	                throw new InputsException("Error: El ID de la mascota debe ser mayor que cero.");
	            }
	            if (request.getOwner() == null || request.getOwner().getId() <= 0) {
	                throw new InputsException("Error: La mascota debe estar asociada a un dueño válido.");
	            }

	            // Crear objeto Pet con validaciones
	            Pet pet = new Pet();
	            pet.setPetID(request.getPetID());
	            pet.setPetName(petValidator.petNameValidator(request.getPetName()));
	            pet.setOwner(request.getOwner());
	            pet.setAnimalSpecies(petValidator.animalSpeciesValidator(request.getAnimalSpecies()));
	            pet.setAnimalBreed(petValidator.animalBreedValidator(request.getAnimalBreed()));
	            pet.setCharacteristics(petValidator.characteristicsValidator(request.getCharacteristics()));
	            pet.setAge(request.getAge());
	            pet.setWeight(petValidator.weightValidator(Long.toString(request.getWeight())));

	            // Registrar mascota en la BD
	            veterinarianService.registerPet(pet);

	            return new ResponseEntity<>("Mascota registrada exitosamente.", HttpStatus.OK);
	        } catch (BusinessException be) {
	            return new ResponseEntity<>(be.getMessage(), HttpStatus.CONFLICT);
	        } catch (InputsException ie) {
	            return new ResponseEntity<>(ie.getMessage(), HttpStatus.BAD_REQUEST);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

		@PostMapping("/owner")
	    public ResponseEntity<String> createOwner(@RequestBody PersonRequest request) {
	        try {
	            System.out.println("Solicitud de dueño recibida: " + request.toString());

	            // 🔹 Validar datos antes de registrar
	            if (request.getId() <= 0) {
	                throw new InputsException("Error: El ID del dueño debe ser mayor que cero.");
	            }

	            // Crear objeto Person con validaciones
	            Person owner = new Person();
	            owner.setId(personValidator.idValidator(Long.toString(request.getId())));
	            owner.setName(personValidator.nameValidator(request.getName()));
	            owner.setAge(personValidator.ageValidator(Long.toString(request.getAge())));
	            owner.setRole(personValidator.roleValidator(request.getRole()));

	            // Registrar dueño en la BD
	            veterinarianService.registerOwner(owner);

	            return new ResponseEntity<>("Dueño registrado exitosamente.", HttpStatus.OK);
	        } catch (BusinessException be) {
	            return new ResponseEntity<>(be.getMessage(), HttpStatus.CONFLICT);
	        } catch (InputsException ie) {
	            return new ResponseEntity<>(ie.getMessage(), HttpStatus.BAD_REQUEST);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
		
		
		@PostMapping("/order")
		public ResponseEntity<String> createOrder(@RequestBody OrderRequest request) {
		    try {
		        System.out.println("Solicitud de orden recibida: " + request.toString());

		        // 🔹 Validar datos, pero SIN exigir que `orderID` sea mayor que cero
		        if (request.getPet() == null || request.getPet().getPetID() <= 0) {
		            throw new InputsException("Error: La orden debe estar asociada a una mascota válida.");
		        }
		        if (request.getVeterinarian() == null || request.getVeterinarian().getId() <= 0) {
		            throw new InputsException("Error: La orden debe estar asociada a un veterinario válido.");
		        }

		        // ✅ Permitir que la BD genere `orderID`
		        Order order = new Order();
		        order.setPet(request.getPet());
		        order.setOwner(request.getOwner());
		        order.setVeterinarian(request.getVeterinarian());
		        order.setMedicine(request.getMedicine());
		        order.setDate(request.getDate());

		        // 🔹 Registrar la orden en la BD
		        Order newOrder = veterinarianService.createOrder(order);

		        return new ResponseEntity<>("Orden creada con ID " + newOrder.getOrderID(), HttpStatus.OK);
		    } catch (BusinessException be) {
		        return new ResponseEntity<>(be.getMessage(), HttpStatus.CONFLICT);
		    } catch (InputsException ie) {
		        return new ResponseEntity<>(ie.getMessage(), HttpStatus.BAD_REQUEST);
		    } catch (Exception e) {
		        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		}



		   
		}
		
