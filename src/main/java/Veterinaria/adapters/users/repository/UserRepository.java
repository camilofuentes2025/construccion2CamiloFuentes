package Veterinaria.adapters.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Veterinaria.adapters.users.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username) ; 
    Optional<UserEntity> findByPersonId(long personId); 
    Optional<UserEntity> findByUsername(String username); 
    List<UserEntity> findByRole(String role); 
}