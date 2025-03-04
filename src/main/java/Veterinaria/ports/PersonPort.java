package Veterinaria.ports;

import Veterinaria.domain.models.Person;

public interface PersonPort {
    Person findByCedula(long cedula);
    void save(Person person);
    void delete(Person person);
}
