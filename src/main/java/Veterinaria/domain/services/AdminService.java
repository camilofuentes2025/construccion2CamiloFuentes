package Veterinaria.domain.services;

import org.springframework.stereotype.Service;


import Veterinaria.domain.models.User;
import Veterinaria.ports.PersonPort;
import Veterinaria.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Service
public class AdminService {
    private PersonPort personPort;
    private UserPort    userPort;

 // Excepciones Personalizadas
    public class PersonAlreadyExistsException extends RuntimeException {
        public PersonAlreadyExistsException(String message) {
            super("ya existe una persona con esa cedula");
        }
    }

    public class UsernameAlreadyExistsException extends RuntimeException {
        public UsernameAlreadyExistsException(String message) {
            super("ya existe un usuario con ese nombre de usuario");
        }
    }

    // Método en el servicio
    public void registerSeller(User seller) {
        validateSeller(seller);
        personPort.savePerson(seller);
        userPort.saveUser(seller);
    }

    // Método de Validación Privado
    private void validateSeller(User seller) {
        if (personPort.existPerson(seller.getId())) {
            throw new PersonAlreadyExistsException("Ya existe una persona con esa cédula.");
        }
        if (userPort.existUserName(seller.getUsername())) {
            throw new UsernameAlreadyExistsException("Ya existe un usuario con ese nombre de usuario.");
        }
        if (seller.getUsername() == null || seller.getUsername().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede ser nulo o vacío.");
        }
    }

 /*public void register_seller(User seller){
    if (personPort.existPerson(seller.getId())){
        throw new Exception("ya existe una persona con esa cedula");
    }
    if (userPort.existUserName(seller.getUsername())) {
        throw new Exception("ya existe un usuario con ese nombre de usuario");
    }

    personPort.savePerson(seller);
    userPort.saveUser(seller);
 }

 public void register_veterinarian(User veterinarian){
    if (personPort.existPerson(veterinarian.getId())){
        throw new Exception("ya existe una persona con esa cedula");
    }
    if (userPort.existUserName(veterinarian.getUsername())) {
        throw new Exception("ya existe un usuario con ese nombre de usuario");
    }

    personPort.savePerson(veterinarian);
    userPort.saveUser(veterinarian);
 }

 
}*/
}
