package th.ac.ku.tutor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.tutor.repository.UserRepository;
import th.ac.ku.tutor.store.TokenStore;
import th.ac.ku.tutor.util.GoogleAuthUtil;

@Service
public class AuthService {
    private GoogleAuthUtil googleAuth;
    private UserRepository userRepository;

    @Autowired
    public AuthService(GoogleAuthUtil googleAuth, UserRepository userRepository) {
        this.googleAuth = googleAuth;
        this.userRepository = userRepository;
    }

    public String auth(String idToken) {
        String email;
        try {
            email = googleAuth.getEmail(idToken);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return TokenStore.getInstance().generateToken(email);
    }

    public boolean isTokenValid(String token) {
        return TokenStore.getInstance().getEmail(token) != null;
    }
}