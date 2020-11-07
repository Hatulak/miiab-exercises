package hatulak.spring.exercises.lesson1.services;

import hatulak.spring.exercises.lesson1.model.User;
import hatulak.spring.exercises.lesson1.repository.NoSuchUserException;
import hatulak.spring.exercises.lesson1.repository.UserAlreadyExistsException;
import org.springframework.stereotype.Service;

public interface UserService {
    User createUser(String username, String password, String name, String email) throws UserAlreadyExistsException;
    User findUser(String username);
    void deleteUser(String username) throws NoSuchUserException;
    boolean verifyUser(String username, String password);
}
