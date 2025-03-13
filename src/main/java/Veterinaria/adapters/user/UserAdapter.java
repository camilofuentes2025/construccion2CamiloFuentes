package Veterinaria.adapters.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Veterinaria.adapters.users.entity.UserEntity;
import Veterinaria.adapters.users.repository.UserRepository;
import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.User;
import Veterinaria.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Service
public class UserAdapter implements UserPort {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean existUserName(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        UserEntity userEntity = convertToUserEntity(user);
        userRepository.save(userEntity);
        user.setId(userEntity.getId());
    }

    @Override
    public User findByPersonId(long id) {
        UserEntity userEntity = userRepository.findByPersonId(id);
        return convertToUser(userEntity);
    }

    @Override
    public User registerDealer(Person person) {
        User user = new User();
        user.setId(person.getId());
        user.setName(person.getName());
        user.setAge(person.getAge());
        user.setRole("DEALER");
        user.setUsername(person.getName().toLowerCase() + "_dealer");
        user.setPassword("defaultpassword");

        saveUser(user);
        return user;
    }

    @Override
    public User registerVeterinarian(Person person) {
        User user = new User();
        user.setId(person.getId());
        user.setName(person.getName());
        user.setAge(person.getAge());
        user.setRole("VETERINARIAN");
        user.setUsername(person.getName().toLowerCase() + "_vet");
        user.setPassword("defaultpassword");

        saveUser(user);
        return user;
    }

    private User convertToUser(UserEntity userEntity) {
        if (userEntity == null) return null;
        
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setAge(userEntity.getAge());
        user.setRole(userEntity.getRole());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        return user;
    }

    private UserEntity convertToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        //userEntity.setAge(user.getAge());
        userEntity.setRole(user.getRole());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }
}
