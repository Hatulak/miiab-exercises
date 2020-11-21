package hatulak.spring.exercises.lesson1.services;

import hatulak.spring.exercises.lesson1.model.Group;
import hatulak.spring.exercises.lesson1.model.User;
import hatulak.spring.exercises.lesson1.repository.NoSuchGroupException;
import hatulak.spring.exercises.lesson1.repository.NoSuchUserException;
import hatulak.spring.exercises.lesson1.repository.UserAlreadyExistsException;

import java.util.List;

public interface UserService {
    User createUser(String username, String password, String name, String email) throws UserAlreadyExistsException;
    User findUser(String username);
    void deleteUser(String username) throws NoSuchUserException;
    boolean verifyUser(String username, String password);
    Group createGroup(String groupName);
    void addUserToGroup(String username, String groupName) throws NoSuchUserException;
    void removeUserFromGroup(String username, String groupName) throws NoSuchUserException, NoSuchGroupException;
    List<User> getUsersFromGroup(String groupName)throws NoSuchGroupException;
}
