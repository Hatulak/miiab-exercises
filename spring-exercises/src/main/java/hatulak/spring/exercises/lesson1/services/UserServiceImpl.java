package hatulak.spring.exercises.lesson1.services;

import hatulak.spring.exercises.lesson1.model.User;
import hatulak.spring.exercises.lesson1.repository.NoSuchUserException;
import hatulak.spring.exercises.lesson1.repository.UserAlreadyExistsException;
import hatulak.spring.exercises.lesson1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final HashService hashService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, HashService hashService) {
        this.userRepository = userRepository;
        this.hashService = hashService;
    }

    @Override
    public User createUser(String username, String password, String name, String email) throws UserAlreadyExistsException {
        return userRepository.save(User.builder()
                .username(username)
                .password(hashService.getHash(password))
                .name(name)
                .email(email)
                .build());
    }

    @Override
    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(String username) throws NoSuchUserException {
        User byUsername = userRepository.findByUsername(username);
        if (byUsername == null) throw new NoSuchUserException();
        userRepository.delete(byUsername.getId());
    }

    @Override
    public boolean verifyUser(String username, String password) throws NoSuchUserException {
        User byUsername = userRepository.findByUsername(username);
        if (byUsername == null) throw new NoSuchUserException();
        return hashService.getHash(password).equals(byUsername.getPassword());
    }
}
