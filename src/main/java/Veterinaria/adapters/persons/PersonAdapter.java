package Veterinaria.adapters.persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Veterinaria.adapters.persons.entity.PersonEntity;
import Veterinaria.adapters.persons.repository.PersonRepository;
import Veterinaria.domain.models.Person;
import Veterinaria.ports.PersonPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.*;

@Setter
@Getter
@NoArgsConstructor
@Service
public class PersonAdapter implements PersonPort {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public boolean existPerson(long id) {
        return personRepository.existsById(id);
    }

    @Override
    public void savePerson(Person person) {
        PersonEntity personEntity = convertToPersonEntity(person);
        personRepository.save(personEntity);
        person.setId(personEntity.getId());
    }
  
    @Override
    public Person findById(long id) {
    	PersonEntity personEntity = personRepository.findById(id);
    	return convertToPerson(personEntity);
    }
 
    private Person convertToPerson(PersonEntity personEntity) {
        if (personEntity == null) return null;
        
        Person person = new Person();
        person.setId(personEntity.getId());
        person.setName(personEntity.getName());
        person.setAge(personEntity.getAge());
        person.setRole(personEntity.getRole());
        return person;
    }

    private PersonEntity convertToPersonEntity(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("La persona no puede ser nula.");
        }

        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(person.getId());
        personEntity.setName(person.getName());
        personEntity.setAge(person.getAge());
        personEntity.setRole(person.getRole());
        return personEntity;
    }
}
