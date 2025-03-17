package Veterinaria.ports;


import Veterinaria.domain.models.User;

public interface UserPort {
    boolean existUserName(String username);
    void saveUser(User user);
    User findByPersonId(long id);
}

