package th.ac.ku.tutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.tutor.service.AuthService;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService service;

    @Autowired
    public AuthController(AuthService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity auth(@RequestHeader("X-IdToken") String idToken) {
        if (idToken == null || idToken.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        String token = service.auth(idToken);

        HashMap<String, String> tokenJson = new HashMap<>();
        tokenJson.put("token", token);

        return ResponseEntity.ok(tokenJson);
    }
}
