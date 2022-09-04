package com.hproject.banttang.user.infra.connector.google;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Optional;

@Component
public class GoogleClient {
    private final GoogleProperties properties;

    @Autowired
    public GoogleClient(GoogleProperties properties) {
        this.properties = properties;
    }

    public Optional<String> verify(String idTokenString) {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                .setAudience(Collections.singletonList(properties.getClientId()))
                .build();

        try {
            GoogleIdToken idToken = verifier.verify(idTokenString);

            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();
                return Optional.ofNullable(payload.getSubject());
            } else {
                return Optional.empty();
            }
        } catch (IllegalStateException | IOException | GeneralSecurityException e) {
            return Optional.empty();
        }
    }
}
