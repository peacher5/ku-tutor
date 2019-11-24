package th.ac.ku.tutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.tutor.model.User;
import th.ac.ku.tutor.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User postUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping
    public boolean deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }

    @GetMapping
    public User getUser(@RequestAttribute User user) {
        return user;
    }
}
