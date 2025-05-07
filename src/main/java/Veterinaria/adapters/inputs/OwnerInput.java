package Veterinaria.adapters.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Veterinaria.adapters.inputs.utils.PersonValidator;
import Veterinaria.adapters.inputs.utils.PetValidator;
import Veterinaria.adapters.inputs.utils.UserValidator;
import Veterinaria.adapters.inputs.utils.Utils;
import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;
import Veterinaria.ports.InputPort;
import Veterinaria.ports.PersonPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Component
public class OwnerInput implements InputPort {
	
    @Autowired
    private PetValidator petValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private PersonPort personPort;
   
    

    private final String MENU = "Ingrese la opción:"
            + "\n 1. Registrar nueva mascota."
            + "\n 2. Consultar datos de mascotas registradas."
            + "\n 3. Salir.";

    @Override
    public void menu() {
        System.out.println(MENU);
        String option = Utils.getReader().nextLine();
        switch (option) {
            case "1": {
                try {
                    this.registerPet();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case "2": {
                this.viewPets();
                break;
            }
            case "3": {
                System.out.println("Hasta una próxima ocasión.");
                return;
            }
            default: {
                System.out.println("Opción no válida.");
            }
        }
    }

    private void registerPet() throws Exception {
        System.out.println("Ingrese el nombre de la mascota:");
        String petname = petValidator.petNameValidator(Utils.getReader().nextLine());
       
        System.out.println("Ingrese la cédula del dueño:");
        long ownerID;
        try {
   
            ownerID = personValidator.longValidator(Utils.getReader().nextLine(), "Cédula del dueño");
        } catch (Exception e) {
            throw new Exception("Error en la cédula del dueño: " + e.getMessage());
        }

        Person owner = personPort.findById(ownerID);
        if (owner == null || !owner.getRole().equalsIgnoreCase("dueño mascota")) {
            throw new Exception("El dueño de mascota con cédula " + ownerID + " no está registrado o no tiene el rol de dueño mascota.");
        }

        System.out.println("El dueño de la mascota fue validado correctamente.");

        
        System.out.println("Ingrese la edad de la mascota:");
        long age = petValidator.ageValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese el ID de la mascota:");
        long petID = petValidator.petIDValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese la especie de la mascota (perro, gato, pez, ave):");
        String animalSpecies = petValidator.animalSpeciesValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese la raza de la mascota:");
        String animalBreed = petValidator.animalBreedValidator(Utils.getReader().nextLine()); 
        System.out.println("Ingrese las características de la mascota (color, tamaño):");
        String characteristics = petValidator.characteristicsValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese el peso de la mascota en kg:");
        long weight = petValidator.weightValidator(Utils.getReader().nextLine());

        Pet pet = new Pet();
        pet.setPetName(petname);
        pet.setOwner(owner);
        pet.setAge(age);
        pet.setPetID(petID);
        pet.setAnimalSpecies(animalSpecies);
        pet.setAnimalBreed(animalBreed);
        pet.setCharacteristics(characteristics);
        pet.setWeight(weight);

        /*// ID único generado automáticamente
        long uniquePetId = System.currentTimeMillis(); // Puedes usar una mejor lógica para generar IDs
        pet.setPetID(uniquePetId);

        System.out.println("Mascota registrada exitosamente con ID: " + uniquePetId);*/
    }

    private void viewPets() {
        // Aquí consultarías la lista de mascotas en memoria y mostrarías sus datos
        System.out.println("Mostrando lista de mascotas registradas...");
        // Por ejemplo, iterar sobre un vector o lista que almacena las mascotas.
    }
}