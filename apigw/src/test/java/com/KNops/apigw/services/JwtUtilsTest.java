package com.KNops.apigw.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@SpringBootTest
class JwtUtilsTest {

    @InjectMocks
    private JwtUtils jwtUtils;

    @Mock
    private Key key;


    @Test
    void testExtractUsername() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        when(jwtUtils.extractClaim(token, Claims::getSubject)).thenReturn("testUser");

        String username = jwtUtils.extractUsername(token);

        assertThat(username).isEqualTo("testUser");
    }

    @Test
    void testIsExpired() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        Date expirationDate = new Date(System.currentTimeMillis() + 10000); // Token expires in the future
        when(jwtUtils.extractExpiration(token)).thenReturn(expirationDate);

        boolean isExpired = jwtUtils.isExpired(token);

        assertThat(isExpired).isFalse(); // Token should not be expired
    }

    @Test
    void testIsExpiredExpiredToken() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        Date expirationDate = new Date(System.currentTimeMillis() - 10000); // Token expires in the past
        when(jwtUtils.extractExpiration(token)).thenReturn(expirationDate);

        boolean isExpired = jwtUtils.isExpired(token);

        assertThat(isExpired).isTrue(); // Token should be expired
    }



    @Test
    void testExtractAllClaims() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        // Mock Jwts.parserBuilder() to return a mock claims
        Claims mockClaims = Jwts.claims();
        when(jwtUtils.extractAllClaims(token)).thenReturn(mockClaims);

        Claims claims = jwtUtils.extractAllClaims(token);

        assertThat(claims).isNotNull();
    }
}
