package com.example.uberprojectauthservice.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService{

    @Value("${jwt.expiry}")
    private int expiry;

    @Value("${jwt.secret}")
    private String SECRET;


    @Override
    public void run(String... args) throws Exception {
        Map<String,Object> mp = new HashMap<>();
        mp.put("email", "divyansh@gmail.com");
        mp.put("phonenumber","49032748927974");
        String result = createToken(mp, "divyansh");
    }

    @Override
    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * This method checks if the token expiry was before current time stamp of now
     * @param token
     * @return true if token is expired else false
     */
    @Override
    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    @Override
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    @Override
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public Object extractPayload(String token, String payload) {
        Claims claims = extractAllClaims(token);
        return (Object) claims.get(payload);
    }

    @Override
    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }

    @Override
    public Key getSignInKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public Boolean validateToken(String token, String email) {
        final String userEmailFetchedFromToken = extractEmail(token);
        return userEmailFetchedFromToken.equals(email) && !isTokenExpired(token);
    }

    @Override
    public String createToken(Map<String, Object> payload,String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiry * 1000L);

        return Jwts.builder()
                .claims(payload)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expiryDate)
                .subject(email)
                .signWith(getSignInKey())
                .compact();
    }

    @Override
    public String createToken(String email) {
        return createToken(new HashMap<>(), email);
    }
}
