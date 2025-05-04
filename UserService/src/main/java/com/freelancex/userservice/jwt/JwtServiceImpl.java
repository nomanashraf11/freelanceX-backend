package com.freelancex.userservice.jwt;

import com.freelancex.userservice.dtos.common.JwtBody;
import com.freelancex.userservice.enums.UserRole;
import com.freelancex.userservice.jwt.interfaces.JwtService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String generateToken(String email, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public JwtBody validateToken(String token) throws JwtException {
        try {
            Claims claims = getAllClaimsFromToken(token);
            if (isTokenExpired(token)) {
                throw new JwtException("JWT token is expired");
            }

            String role = (String) claims.get("role");
            String email = (String) claims.get("email");

            return new JwtBody(email, role);
        } catch (ExpiredJwtException e) {
            throw new JwtException("JWT token is expired");
        } catch (MalformedJwtException | SignatureException e) {
            throw new JwtException("Invalid JWT token");
        } catch (Exception e) {
            throw new JwtException("JWT token validation failed: " + e.getMessage());
        }
    }

    private boolean isTokenExpired(String token) {
        return getClaimFromToken(token, Claims::getExpiration).before(new Date());
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}