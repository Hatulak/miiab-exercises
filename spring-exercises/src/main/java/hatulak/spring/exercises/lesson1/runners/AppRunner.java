package hatulak.spring.exercises.lesson1.runners;

import hatulak.spring.exercises.lesson1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public AppRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Saving test, test2, test3 users");
        userService.createUser("test", "test", "test", "test@test.pl");
        userService.createUser("test2", "test2", "test2", "test2@test.pl");
        userService.createUser("test3", "test3", "test3", "test3@test.pl");

        System.out.println("Search for test3 user:");
        System.out.println(userService.findUser("test3"));

        System.out.println("Deleting test3 user...");
        userService.deleteUser("test3");

        System.out.println("Search for test3 user:");
        System.out.println(userService.findUser("test3"));

        System.out.println("Verifying test user with \"test\" password");
        System.out.println(userService.verifyUser("test", "test"));

        System.out.println("Verifying test user with \"test123\" password");
        System.out.println(userService.verifyUser("test", "test123"));


    }
}
