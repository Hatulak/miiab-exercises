package hatulak.spring.exercises.lesson1.repository;

import hatulak.spring.exercises.lesson1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Optional<User> findById(Long id);
    boolean existsByUsername(String username);
    void deleteById(Long id);
    List<User> findAll();
}
