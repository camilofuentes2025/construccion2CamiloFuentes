package Veterinaria.ports;

import Veterinaria.domain.models.Person;

public interface PersonPort {
    boolean existPerson(long id);
    void savePerson(Person person);
    Person findById(long id);
}

