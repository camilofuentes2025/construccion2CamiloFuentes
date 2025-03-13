package Veterinaria.adapters.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Veterinaria.adapters.users.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username);
    UserEntity findByPersonId(long id);
}
