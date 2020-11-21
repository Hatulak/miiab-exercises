package hatulak.spring.exercises.lesson1.services;

import hatulak.spring.exercises.lesson1.model.Group;
import hatulak.spring.exercises.lesson1.model.User;
import hatulak.spring.exercises.lesson1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final GroupRepository groupRepository;

    private final HashService hashService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, GroupRepository groupRepository, HashService hashService) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.hashService = hashService;
    }

    @Override
    public User createUser(String username, String password, String name, String email) throws UserAlreadyExistsException {
        if (userRepository.existsByUsername(username)) throw new UserAlreadyExistsException();
        return userRepository.saveAndFlush(User.builder()
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
        userRepository.deleteById(byUsername.getId());
    }

    @Override
    public boolean verifyUser(String username, String password) throws NoSuchUserException {
        User byUsername = userRepository.findByUsername(username);
        if (byUsername == null) throw new NoSuchUserException();
        return hashService.getHash(password).equals(byUsername.getPassword());
    }

    @Override
    public Group createGroup(String name) {
        return groupRepository.saveAndFlush(Group.builder().name(name).build());
    }

    @Override
    public void addUserToGroup(String username, String groupName) throws NoSuchUserException {
        User byUsername = userRepository.findByUsername(username);
        if (byUsername == null) throw new NoSuchUserException();
        Group byName = groupRepository.findByName(groupName);
        if (byName == null) throw new NoSuchGroupException();
        byUsername.setUserGroup(byName);
        userRepository.saveAndFlush(byUsername);
    }

    @Override
    public void removeUserFromGroup(String username, String groupName) throws NoSuchUserException, NoSuchGroupException {
        User byUsername = userRepository.findByUsername(username);
        if (byUsername == null) throw new NoSuchUserException();
        Group byName = groupRepository.findByName(groupName);
        if (byName == null) throw new NoSuchGroupException();
        byUsername.setUserGroup(null);
        userRepository.saveAndFlush(byUsername);
    }

    @Override
    public List<User> getUsersFromGroup(String groupName) throws NoSuchGroupException {
        Group byName = groupRepository.findByName(groupName);
        if (byName == null) throw new NoSuchGroupException();
        return byName.getUserList();
    }
}
