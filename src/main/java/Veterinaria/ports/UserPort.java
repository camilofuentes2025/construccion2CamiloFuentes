package Veterinaria.ports;

import Veterinaria.domain.models.User;

public interface UserPort {
    User findByUserName(String userName);
    void save(User user);
    void delete(User user);
}