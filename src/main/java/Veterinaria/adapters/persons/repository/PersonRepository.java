package Veterinaria.adapters.persons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Veterinaria.adapters.persons.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    boolean existsById(long id);
    PersonEntity findById(long id);
}
