package hatulak.spring.exercises;

import hatulak.spring.exercises.lesson1.model.Group;
import hatulak.spring.exercises.lesson1.model.User;
import hatulak.spring.exercises.lesson1.repository.GroupRepository;
import hatulak.spring.exercises.lesson1.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GroupTests {

    private final UserService userService;

    private final GroupRepository groupRepository;

    @Autowired
    public GroupTests(UserService userService, GroupRepository groupRepository) {
        this.userService = userService;
        this.groupRepository = groupRepository;
    }

    @Test
    public void createGroupTest() {
        String testString = "test";
        Group test = userService.createGroup(testString);
        Assertions.assertNotNull(groupRepository.findByName(testString));
        Assertions.assertEquals(testString, groupRepository.findByName(testString).getName());
        Assertions.assertEquals(0, groupRepository.findByName(testString).getUserList().size());
        Assertions.assertNotNull(groupRepository.findByName(testString).getId());
    }

    @Test
    public void addUserToGroupTest() {
        User user = userService.createUser("name2", "passwd2", "name2", "email2@emailpl");
        Group test = userService.createGroup("testGroup2");
        userService.addUserToGroup(user.getName(), test.getName());
        Assertions.assertEquals(user.getId(), userService.getUsersFromGroup("testGroup2").get(0).getId());
    }

    @Test
    public void removeUserFromGroupTest() {
        User user = userService.createUser("name", "passwd", "name", "email@emailpl");
        Group testGroup = userService.createGroup("testGroup");
        userService.addUserToGroup(user.getName(), testGroup.getName());
        Assertions.assertEquals(user.getId(), userService.getUsersFromGroup("testGroup").get(0).getId());
        userService.removeUserFromGroup(user.getName(), testGroup.getName());
        Assertions.assertEquals(0, userService.getUsersFromGroup("testGroup").size());
    }
}
