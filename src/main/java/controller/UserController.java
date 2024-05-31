package controller;

import exception.UserNotFoundException;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

@Controller
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

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
    public String updateUser(@RequestParam User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user/delete")
    public String deleteUser(@RequestParam("id") long id) throws UserNotFoundException {
        User user = userService.getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        userService.deleteUser(user);

        return "redirect:/users";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(Model model, UserNotFoundException ex) {
        logger.error(ex.getMessage());
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
}
