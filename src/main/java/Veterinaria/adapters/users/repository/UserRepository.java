package Veterinaria.adapters.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Veterinaria.adapters.users.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username);
    Optional<UserEntity> findByPersonId(long personId);
}
