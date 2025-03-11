package Veterinaria.adapters.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Veterinaria.adapters.adaptersUsers.UserEntity;
import Veterinaria.adapters.adaptersUsers.UserRepository;
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
    public boolean existUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public void saveUser(User user) {
        UserEntity userEntity = userAdapter(user);
        userRepository.save(userEntity);
        user.setId(userEntity.getId());
    }

    @Override
    public User findByPersonId(long id) {
        UserEntity userEntity = userRepository.findByPersonId(id);
        return userAdapter(userEntity);
    }

    @Override
    public User registerSeller(Person person) {
        User user = new User();
        user.setId(person.getId());
        user.setName(person.getName());
        user.setAge(person.getAge());
        user.setRole("SELLER");
        user.setUserName(person.getName().toLowerCase() + "_seller");
        user.setPassword("defaultPassword");

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
        user.setUserName(person.getName().toLowerCase() + "_vet");
        user.setPassword("defaultPassword");

        saveUser(user);
        return user;
    }

    private User userAdapter(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setAge(userEntity.getAge());
        user.setRole(userEntity.getRole());
        user.setUserName(userEntity.getUserName());
        user.setPassword(userEntity.getPassword());
        return user;
    }

    private UserEntity userAdapter(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setAge(user.getAge());
        userEntity.setRole(user.getRole());
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }
}

