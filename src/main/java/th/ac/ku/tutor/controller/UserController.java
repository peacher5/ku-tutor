package th.ac.ku.tutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.tutor.model.User;
import th.ac.ku.tutor.service.AuthService;
import th.ac.ku.tutor.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private AuthService authService;

    @Autowired
    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/create")
    public ResponseEntity postUser(@RequestHeader("X-Token") String token, @RequestBody User user) {
        System.out.println("hi");
        System.out.println(user);
        String email = authService.getEmail(token);

        if (email == null || !email.endsWith("ku.th")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        user.setEmail(email);
        userService.createUser(user);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public User getUser(@RequestAttribute User user) {
        return user;
    }
}
