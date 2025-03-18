package Veterinaria.ports;

import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.User;

public interface UserPort {
    boolean existUserName(String username);
    void saveUser(User user);
    User findByPersonId(long id);
    User registerDealer(Person person);
    User registerVeterinarian(Person person);
}

