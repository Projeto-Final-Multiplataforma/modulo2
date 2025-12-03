package com.example.modulo2.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.example.modulo2.entities.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtSecurity {

    private static final String SECRET = "55484d9a1cffc2efafe532be6aed576109705c465047562bd0d5abc2b37ad568";
    private static final long EXP = 3600000;

    public String generateJwt(User user) {
        Date date = new Date();
        SecretKey key = Keys.hmacShaKeyFor(getSecret());
        return Jwts.builder()
            .subject(user.username())
            .issuedAt(date)
            .expiration(new Date(date.getTime() + EXP))
            .signWith(key, Jwts.SIG.HS256)
            .compact();
    }

    private byte[] getSecret() {
        return SECRET.getBytes();
    }
}
