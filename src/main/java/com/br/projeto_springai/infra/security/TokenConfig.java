package com.br.projeto_springai.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.br.projeto_springai.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {

    @Value("${secretKey}")
    private String secretKey;


    public String generateToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        return JWT.create()
                .withClaim("userId", user.getUserId())
                .withSubject(user.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(84600))
                .sign(algorithm);
    }

    public Optional<JWTUserData> validateToken(String token) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            DecodedJWT decode = JWT.require(algorithm).build().verify(token);

            return Optional.of(JWTUserData.builder()
                    .id(decode.getClaim("userId").asLong())
                    .email(decode.getSubject())
                    .build());

        }catch (JWTVerificationException e){
            return Optional.empty();
        }
    }
}
