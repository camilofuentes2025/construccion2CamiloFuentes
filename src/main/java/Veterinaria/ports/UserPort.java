package Veterinaria.ports;

import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.User;

public interface UserPort {
    public boolean existUserName(String userName);

    public void saveUser(User user);

    public User findByPersonId(long Id);

    public User registerSeller(Person person);

    public User registerVeterinarian(Person person);
    
    
}