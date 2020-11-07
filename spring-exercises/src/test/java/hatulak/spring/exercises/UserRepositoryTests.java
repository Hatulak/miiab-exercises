package hatulak.spring.exercises;

import hatulak.spring.exercises.lesson1.model.User;
import hatulak.spring.exercises.lesson1.repository.UserRepository;
import hatulak.spring.exercises.lesson1.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTests {

    private final UserService userService;

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryTests(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Test
    public void findByIdTest() {
        User user = userService.createUser("toFindById", "toFindById", "toFindById", "toFindById@toFindById.pl");
        Assertions.assertNotNull(userRepository.findById(user.getId()));
        Assertions.assertNull(userRepository.findById(123L));
    }

    @Test
    public void findAllTest() {
        //Command Line Runner is creating 2 instances of user
        Assertions.assertEquals(2, userRepository.findAll().size());
    }
}
