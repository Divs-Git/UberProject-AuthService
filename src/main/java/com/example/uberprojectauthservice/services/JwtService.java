package com.example.uberprojectauthservice.services;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public interface JwtService extends CommandLineRunner {

    /**
     * This method creates a brand-new JWT Token based on payload.
     * @return String
     */
    public String createToken(Map<String,Object> payload,String email);

    public String extractEmail(String token);

    public Boolean isTokenExpired(String token);

    public Date extractExpiration(String token);

    public Boolean validateToken(String token, String email);

    public Object extractPayload(String token, String payload);

    public Claims extractAllClaims(String token);

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    public Key getSignInKey();

}
