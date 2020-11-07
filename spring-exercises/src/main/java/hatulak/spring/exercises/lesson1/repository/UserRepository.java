package hatulak.spring.exercises.lesson1.repository;

import hatulak.spring.exercises.lesson1.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository {
    User save(User user);
    List<User> findAll();
    User findById(Long id);
    void delete(Long id);
    User findByUsername(String username);
}
