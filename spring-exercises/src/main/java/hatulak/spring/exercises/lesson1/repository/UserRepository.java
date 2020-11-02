package hatulak.spring.exercises.lesson1.repository;

import hatulak.spring.exercises.lesson1.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Long, User> {
}
