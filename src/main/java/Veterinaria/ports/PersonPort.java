package Veterinaria.ports;

import Veterinaria.domain.models.Person;

public interface PersonPort {
    public Person findById(long Id);
    public boolean existPerson(long Id);
    public void savePerson(Person person);
}
