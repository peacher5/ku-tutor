package th.ac.ku.tutor.util;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Component
public class GoogleAuthUtil {
    @Value("${tutor.ios.client-id}")
    private String iosClientId;

    private JacksonFactory jacksonFactory = new JacksonFactory();
    private NetHttpTransport netHttpTransport = new NetHttpTransport();
    private GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(netHttpTransport, jacksonFactory)
            .setAudience(Collections.singletonList(iosClientId))
            .build();

    public String getEmail(String idToken) throws IllegalArgumentException {
        GoogleIdToken googleIdToken;

        try {
            googleIdToken = verifier.verify(idToken);
        } catch (GeneralSecurityException | IOException e) {
            throw new IllegalArgumentException("Invalid ID token.");
        }

        if (googleIdToken != null) {
            GoogleIdToken.Payload payload = googleIdToken.getPayload();
            return payload.getEmail();
        }

        throw new IllegalArgumentException("Invalid ID token.");
    }
}
