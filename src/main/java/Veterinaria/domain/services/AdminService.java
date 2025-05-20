package Veterinaria.domain.services;

import Veterinaria.Exceptions.BusinessException;
import Veterinaria.domain.models.User;
import Veterinaria.ports.PersonPort;
import Veterinaria.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private void registerUserRole(User user, String role) throws Exception {
        if (personPort.existPerson(user.getId())) {
            throw new BusinessException("Error: La cédula ya está registrada.");
        }
        if (userPort.existUserName(user.getUsername())) {
            throw new BusinessException("Error: Nombre de usuario ya registrado.");
        }

        user.setRole(role);
        personPort.savePerson(user);
        userPort.saveUser(user);
    }

    public void registerDealer(User dealer) throws Exception {
        registerUserRole(dealer, ROLE_DEALER);
    }

    public void registerVeterinarian(User veterinarian) throws Exception {
        registerUserRole(veterinarian, ROLE_VETERINARIAN);
    }
}