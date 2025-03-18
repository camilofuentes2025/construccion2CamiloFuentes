package Veterinaria.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Veterinaria.domain.models.User;
import Veterinaria.ports.UserPort;

@Service
public class LoginService {

    @Autowired
    private UserPort userPort;

    public User login(User user) throws Exception {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("El usuario, nombre de usuario o contraseña no pueden ser nulos.");
        }

        // Buscar usuario por el username
        User userValidate = userPort.findByPersonId(user.getId()); // Cambia a `findByPersonId`

        if (userValidate == null) {
            throw new Exception("Usuario o contraseña inválido.");
        }

        // Comparar contraseñas
        if (!user.getPassword().equals(userValidate.getPassword())) {
            throw new Exception("Usuario o contraseña inválido.");
        }

        return userValidate;
    }
}
