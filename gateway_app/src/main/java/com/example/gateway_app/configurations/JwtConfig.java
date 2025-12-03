package com.example.gateway_app.configurations;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;

@Configuration
public class JwtConfig {
    @Bean
    public ReactiveJwtDecoder jwtDecoder() {
        String CHAVE_JWT = "55484d9a1cffc2efafe532be6aed576109705c465047562bd0d5abc2b37ad568";
        return NimbusReactiveJwtDecoder.withSecretKey(
                new SecretKeySpec(
                    CHAVE_JWT.getBytes(),
                    "HmacSHA256"
                )
        ).build();
    }
}
