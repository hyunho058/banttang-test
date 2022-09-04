package com.hproject.banttang.user.infra.connector.google;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "google")
@ConstructorBinding
public class GoogleProperties {
    private final String baseUrl;
    private final String clientId;

    public GoogleProperties(String baseUrl, String clientId) {
        this.baseUrl = baseUrl;
        this.clientId = clientId;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getClientId() {
        return clientId;
    }
}
