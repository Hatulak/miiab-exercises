package hatulak.spring.exercises.lesson1.controllers;

import hatulak.spring.exercises.lesson1.model.Group;
import hatulak.spring.exercises.lesson1.model.User;
import hatulak.spring.exercises.lesson1.services.UserService;
import org.h2.engine.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("groups", userService.getGroups());
        return "index";
    }

    @GetMapping("/createGroup")
    public String createGroup(Group group) {
        return "createGroup";
    }

    @PostMapping("/createGroup")
    public String submitCreateGroup(Group group, BindingResult bindingResult, Model model) {
        userService.createGroup(group.getName());
        return "redirect:/";
    }

    @GetMapping("/addUser")
    public String addUser(User user, Model model) {
        model.addAttribute("groups", userService.getGroups());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String submitAddUser(User user, BindingResult bindingResult, Model model) {
        userService.createUser(user.getUsername(), user.getPassword(), user.getName(), user.getEmail());
        userService.addUserToGroup(user.getUsername(), user.getUserGroup().getName());
        return "redirect:/";
    }

    @GetMapping("/editGroup/{id}")
    public String updateGroup(@PathVariable("id") long id, Model model) {
        model.addAttribute("group", userService.findGroup(id));
        return "editGroup";
    }

    @PostMapping("/editGroup/{id}")
    public String submitUpdateGroup(@PathVariable("id") long id, Group group, Model model) {
        group.setId(id);
        userService.updateGroup(group);
        return "redirect:/";
    }

    @GetMapping("/editUser/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        User userById = userService.findUserById(id);
        model.addAttribute("user", userById);
        model.addAttribute("groups", userService.getGroups());
        return "editUser";
    }

    @PostMapping("/editUser/{id}")
    public String submitUpdateGroup(@PathVariable("id") long id, User user, Model model) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteeUser(@PathVariable("id") long id, Model model) {
        User userById = userService.findUserById(id);
        userService.deleteUser(userById.getUsername());
        return "redirect:/";
    }

}
