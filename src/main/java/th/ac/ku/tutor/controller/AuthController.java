package th.ac.ku.tutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.ac.ku.tutor.service.AuthService;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public ResponseEntity auth(@RequestHeader("X-IdToken") String idToken) {
        if (idToken == null || idToken.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        String token = authService.auth(idToken);

        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        HashMap<String, String> tokenJson = new HashMap<>();
        tokenJson.put("token", token);

        return ResponseEntity.ok(tokenJson);
    }
}
