package Veterinaria.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Veterinaria.domain.models.User;
import Veterinaria.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service
public class LoginService {

    @Autowired
    private UserPort userPort;

    public User login(User user) throws Exception {
        
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            throw new Exception("El usuario, nombre de usuario o contraseña no pueden ser nulos.");
        }

        User userValidate = userPort.findByUserName(user.getUsername());
        if (userValidate == null) {
            throw new Exception("Usuario no encontrado.");
        }

        if (!user.getPassword().equals(userValidate.getPassword())) {
            throw new Exception("Contraseña incorrecta.");
        }

        return userValidate;
    }
}
