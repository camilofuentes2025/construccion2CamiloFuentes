package Veterinaria.ports;

import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.User;

import java.util.List;

public interface UserPort {
    boolean existUserName(String username); 
    void saveUser(User user) throws Exception ;
    User findByPersonId(long id);
    User registerDealer(Person person); 
    User registerVeterinarian(Person person);
    List<User> findUsersByRole(String role); 
    User findByUserName(String username); 
}