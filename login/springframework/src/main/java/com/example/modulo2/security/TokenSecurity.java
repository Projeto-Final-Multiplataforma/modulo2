package com.example.modulo2.security;

import com.example.modulo2.entities.Token;

import com.example.modulo2.entities.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class TokenSecurity {

    private final AuthenticationManager authenticationManager;
    private final JwtSecurity jwtSecurity;
    public TokenSecurity(
        AuthenticationManager authenticationManager,
        UserDetailsService userDetailsService,
        JwtSecurity jwtSecurity
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtSecurity = jwtSecurity;
    }

    public Token logar(User user) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
            new UsernamePasswordAuthenticationToken(
                user.username(), user.senha());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        return new Token(jwtSecurity.generateJwt(user));
    }
}
