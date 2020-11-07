package hatulak.spring.exercises;

import hatulak.spring.exercises.lesson1.model.User;
import hatulak.spring.exercises.lesson1.repository.NoSuchUserException;
import hatulak.spring.exercises.lesson1.repository.UserAlreadyExistsException;
import hatulak.spring.exercises.lesson1.services.HashService;
import hatulak.spring.exercises.lesson1.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    private final UserService userService;

    private final HashService hashService;

    @Autowired
    public UserServiceTests(UserService userService, HashService hashService) {
        this.userService = userService;
        this.hashService = hashService;
    }


    @Test
    public void userSaveTest() {
        User savedUser = userService.createUser("usernameTest", "passwordTest", "nameTest", "emailTest@test.pl");
        Assertions.assertNotNull(savedUser.getId());
        Assertions.assertEquals("usernameTest", savedUser.getUsername());
        Assertions.assertEquals("nameTest", savedUser.getName());
        Assertions.assertEquals("emailTest@test.pl", savedUser.getEmail());
        Assertions.assertEquals(hashService.getHash("passwordTest"), savedUser.getPassword());
    }

    @Test
    public void userAlreadyExistsTest() {
        User savedUser = userService.createUser("exists", "exists", "exists", "exists@test.pl");
        Assertions.assertThrows(UserAlreadyExistsException.class, () -> userService.createUser("exists", "exists", "exists", "exists@test.pl"));
    }

    @Test
    public void findUserTest() {
        userService.createUser("findUserTest", "findUserTest", "findUserTest", "findUserTest@findUserTest.pl");
        User testUser = userService.findUser("findUserTest");
        Assertions.assertNotNull(testUser.getId());
        Assertions.assertEquals("findUserTest", testUser.getUsername());
        Assertions.assertEquals("findUserTest", testUser.getName());
        Assertions.assertEquals("findUserTest@findUserTest.pl", testUser.getEmail());
        Assertions.assertEquals(hashService.getHash("findUserTest"), testUser.getPassword());
    }

    @Test
    public void findUserThatNotExistsTest() {
        Assertions.assertNull(userService.findUser("nonExistentUser"));
    }

    @Test
    public void deleteUserTest() {
        userService.createUser("toDelete", "toDelete", "toDelete", "toDelete@toDelete.pl");
        userService.deleteUser("toDelete");
        Assertions.assertNull(userService.findUser("toDelete"));
    }

    @Test
    public void deleteUserThatNotExistsTest() {
        Assertions.assertThrows(NoSuchUserException.class, () -> userService.deleteUser("toDeleteNotExists"));
    }

    @Test
    public void verifyUserTest() {
        userService.createUser("toVerify", "toVerify", "toVerify", "toVerify@toVerify.pl");
        Assertions.assertTrue(userService.verifyUser("toVerify","toVerify"));
        Assertions.assertFalse(userService.verifyUser("toVerify","WrongPassword!"));
    }

    @Test
    public void verifyUserThatNotExistsTest() {
        Assertions.assertThrows(NoSuchUserException.class, () -> userService.verifyUser("userThatNotExists","AnyPassword"));
    }

}
