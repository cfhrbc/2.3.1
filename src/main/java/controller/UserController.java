package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

@Controller
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/users/add")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("/users/update")
    public String updateUser(@RequestParam("id") long id, User user) {
        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setLastName(user.getLastName());
            existingUser.setAge(user.getAge());
            existingUser.setEmail(user.getEmail());
            userService.updateUser(existingUser);
        }
        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam("id") long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUser(user);
        }
        return "redirect:/users";
    }
}
