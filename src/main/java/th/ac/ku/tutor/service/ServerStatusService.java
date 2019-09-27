package th.ac.ku.tutor.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerStatusService {
    @GetMapping
    public boolean getStatus() {
        return true;
    }
}
