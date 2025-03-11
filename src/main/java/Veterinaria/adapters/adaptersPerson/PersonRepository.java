package Veterinaria.adapters.adaptersPerson;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    boolean existsByDocument(long document);

	PersonEntity findByDocument(long document);


 }
