package dev.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class KeyConfig {
    @Bean
    public SecretKey generateKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }
}
