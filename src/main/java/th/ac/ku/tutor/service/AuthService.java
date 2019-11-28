package th.ac.ku.tutor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.tutor.model.Token;
import th.ac.ku.tutor.repository.TokenRepository;
import th.ac.ku.tutor.util.GoogleAuthUtil;
import th.ac.ku.tutor.util.TokenUtil;

@Service
public class AuthService {
    private GoogleAuthUtil googleAuth;
    private TokenRepository tokenRepository;

    @Autowired
    public AuthService(GoogleAuthUtil googleAuth, TokenRepository tokenRepository) {
        this.googleAuth = googleAuth;
        this.tokenRepository = tokenRepository;
    }

    public String auth(String idToken) {
        String email;
        try {
            email = googleAuth.getEmail(idToken);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return generateToken(email);
    }

    private String generateToken(String email) {
        String token = TokenUtil.getInstance().getRandomToken();
        tokenRepository.save(new Token(email, token));
        return token;
    }

    public String getEmail(String tokenString) {
        Token token = tokenRepository.findByToken(tokenString);
        if (token == null) {
            return null;
        }
        return token.getEmail();
    }
}
