package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.User;
import pe.isil.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements BaseService<User, Integer> {

    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> read() {
        return userRepository.findAll();
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<User> readById(Integer s) {
        return userRepository.findById(s);
    }

    public boolean findByEmailAndPassword(String email, String clave){
        return userRepository.findByEmailAndPassword(email,clave);
    }
}
