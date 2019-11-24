package th.ac.ku.tutor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.ac.ku.tutor.model.User;

@RestController
public class UserController {
@RequestMapping("/user")
    @GetMapping
    public User getUser(@RequestAttribute User user) {
        return user;
    }
}