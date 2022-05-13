package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
