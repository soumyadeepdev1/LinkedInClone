package com.linkedIn.users.utils;

import com.linkedIn.users.entity.User;
import com.linkedIn.users.enums.AppRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Set;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

        public String generateToken(String username, Set<AppRole> role){
        return Jwts.builder()
                .subject(username)
                .claim("roles",role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+60*10))
                .signWith(getSigningKey())
                .compact();
    }

    public Claims VerifyToken (String token){
        JwtParser parser = Jwts.parser()
                .verifyWith(getSigningKey())
                .build();
        return parser
                .parseUnsecuredClaims(token.subSequence(0,token.length()))
                .getPayload();
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(
                secret.getBytes()
        );
    }
}
