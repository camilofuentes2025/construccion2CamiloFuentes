package Veterinaria.domain.services;

import Veterinaria.domain.models.User;
import Veterinaria.ports.PersonPort;
import Veterinaria.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Service
public class AdminService {

    @Autowired
    private PersonPort personPort;

    @Autowired
    private UserPort userPort;

    public static final String ROLE_DEALER = "dealer";
    public static final String ROLE_VETERINARIAN = "veterinarian";

    public void registerUser(User user) throws Exception {
        if (personPort.existPerson(user.getId())) {
            throw new Exception("Error: La cédula ya está registrada. No se puede crear un usuario con el mismo documento.");
        }
        if (userPort.existUserName(user.getUsername())) {
            throw new Exception("Error: El nombre de usuario ya está en uso. Por favor, elija uno diferente.");
        }
        userPort.saveUser(user);
        personPort.savePerson(user);
    }

    public void registerDealer(User dealer) throws Exception {
        if (personPort.existPerson(dealer.getId())) {
            throw new Exception("Error al registrar al vendedor: Ya existe una persona con esa cédula.");
        }
        if (userPort.existUserName(dealer.getUsername())) {
            throw new Exception("Error al registrar al vendedor: Nombre de usuario ya registrado. Por favor, elija uno nuevo.");
        }

        dealer.setRole(ROLE_DEALER);
        personPort.savePerson(dealer);
        userPort.saveUser(dealer);
    }

    public void registerVeterinarian(User veterinarian) throws Exception {
        if (personPort.existPerson(veterinarian.getId())) {
            throw new Exception("Error al registrar al veterinario: La cédula ya está registrada en el sistema.");
        }
        if (userPort.existUserName(veterinarian.getUsername())) {
            throw new Exception("Error al registrar al veterinario: Este nombre de usuario ya está en uso. Por favor, intente con otro.");
        }

        veterinarian.setRole(ROLE_VETERINARIAN);
        personPort.savePerson(veterinarian);
        userPort.saveUser(veterinarian);
    }
}