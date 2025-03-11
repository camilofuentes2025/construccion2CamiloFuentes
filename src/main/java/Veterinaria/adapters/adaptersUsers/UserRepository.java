package Veterinaria.adapters.adaptersUsers;

import org.springframework.data.jpa.repository.JpaRepository;

import Veterinaria.adapters.adaptersPerson.PersonEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public boolean existsByUserName(String userName);

	public UserEntity findByPersonId(PersonEntity personEntity); 

}
