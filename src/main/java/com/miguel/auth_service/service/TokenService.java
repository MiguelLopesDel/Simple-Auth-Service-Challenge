package com.miguel.auth_service.service;

import com.miguel.auth_service.domain.UserDTO;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TokenService {

    private static final SecretKey key = Jwts.SIG.HS512.key().build();

    public String generate(UserDTO dto) {
        return Jwts.builder()
                .subject(dto.name())
                .signWith(key)
                .expiration(Date.from(Instant.now().plus(2, ChronoUnit.HOURS)))
                .compact();
    }

    public Optional<String> validate(String token) {
        try {
            return Optional.of(Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject());
        } catch (JwtException e) {
            return Optional.empty();
        }
    }
}
