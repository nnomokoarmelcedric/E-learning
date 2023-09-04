package com.KNops.Authenticationservice.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static io.jsonwebtoken.Jwts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class JwtServiceTest {

    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
    private JwtService jwtService;

    @Mock
    private UserDetails userDetails;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        jwtService = new JwtService();
    }

    @Test
    void testExtractUsername() {
        String token = jwtService.generateToken(new HashMap<>(), userDetails);
        String username = jwtService.extractUsername(token);
        assertThat(username).isEqualTo(userDetails.getUsername());
    }

    @Test
    void testExtractClaim() {
        String claimValue = "custom-claim-value";
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("customClaim", claimValue);

        String token = jwtService.generateToken(extraClaims, userDetails);
        String extractedClaim = jwtService.extractClaim(token, claims -> claims.get("customClaim", String.class));
        assertThat(extractedClaim).isEqualTo(claimValue);
    }

    @Test
    void testGenerateToken() {
        String token = jwtService.generateToken(new HashMap<>(), userDetails);
        assertThat(token).isNotEmpty();
    }

    @Test
    void testIsTokenValid() {
        String token = jwtService.generateToken(new HashMap<>(), userDetails);
        when(userDetails.getUsername()).thenReturn("testuser");
        boolean isValid;
        if (jwtService.isTokenValid(token, userDetails)) isValid = true;
        else isValid = false;
        assertThat(isValid).isTrue();
    }

    @Test
    void testIsTokenExpired() {
        String token = jwtService.generateToken(new HashMap<>(), userDetails);
        boolean isExpired = jwtService.isTokenExpired(token);
        assertThat(isExpired).isFalse();
    }



    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
