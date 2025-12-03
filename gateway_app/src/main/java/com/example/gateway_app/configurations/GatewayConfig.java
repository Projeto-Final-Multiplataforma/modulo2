package com.example.gateway_app.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class GatewayConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
            .csrf(ServerHttpSecurity.CsrfSpec::disable)
            .authorizeExchange(exchange -> exchange
                .pathMatchers(
                        "/v1/login",
                        "/v1/registrar"
                )
                .permitAll()
                .anyExchange()
                .authenticated()
            )
            .oauth2ResourceServer(oauth -> oauth.jwt())
            .build();
    }
}
