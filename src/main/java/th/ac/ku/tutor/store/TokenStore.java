package th.ac.ku.tutor.store;

import th.ac.ku.tutor.util.TokenUtil;

import java.util.HashMap;

public class TokenStore {
    private static final TokenStore tokenStore = new TokenStore();
    private HashMap<String, String> tokenMap = new HashMap<>();
    private TokenUtil tokenUtil = new TokenUtil();

    private TokenStore() {
    }

    public static TokenStore getInstance() {
        return tokenStore;
    }

    public String generateToken(String email) {
        String token;
        do {
            token = tokenUtil.getRandomToken();
        } while (tokenMap.get(token) != null);

        tokenMap.put(token, email);
        return token;
    }

    public String getEmail(String token) {
        return tokenMap.get(token);
    }
}
