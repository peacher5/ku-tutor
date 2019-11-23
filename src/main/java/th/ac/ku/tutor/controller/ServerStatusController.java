package th.ac.ku.tutor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ServerStatusController {
    @GetMapping
    public ResponseEntity getServerStatus() {
        HashMap<String, String> statusJson = new HashMap<>();
        statusJson.put("status", "OK");

        return ResponseEntity.ok(statusJson);
    }
}
