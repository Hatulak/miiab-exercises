package hatulak.spring.exercises.lesson1.repository;

import hatulak.spring.exercises.lesson1.model.User;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class UserRepositoryImpl implements UserRepository {

    private List<User> userList = new LinkedList<>();
    private Long counter = 0L;

    @Override
    public User save(User user) {
        if (findByUsername(user.getUsername()) != null) throw new UserAlreadyExistsException();
        user.setId(counter++);
        userList.add(user);
        return user;
    }

    @Override
    public List<User> findAll(User user) {
        return userList;
    }

    @Override
    public User findById(Long id) {
        List<User> collect = userList.stream().filter(user -> user.getId().equals(id)).collect(Collectors.toList());
        if (collect.size() == 0) return null;
        return collect.get(0);
    }

    @Override
    public void delete(Long id) {
        List<User> collect = userList.stream().filter(user -> user.getId().equals(id)).collect(Collectors.toList());
        if (collect.size() == 0) throw new NoSuchUserException();
        userList.remove(userList.get(0));
    }

    @Override
    public User findByUsername(String username) {
        List<User> collect = userList.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
        if (collect.size() == 0) return null;
        return collect.get(0);
    }
}
