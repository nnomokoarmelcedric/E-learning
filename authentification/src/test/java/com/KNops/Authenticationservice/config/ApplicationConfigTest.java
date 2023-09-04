package com.KNops.Authenticationservice.config;

import com.KNops.Authenticationservice.user.User;
import com.KNops.Authenticationservice.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationConfigTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ApplicationConfig applicationConfig;



    @Test
    void testUserDetailsService() {
        // Simuler le comportement du repository
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(new User()));

        // Appel de la méthode userDetailsService
        UserDetailsService userDetailsService = applicationConfig.userDetailsService();

        // Effectuer des assertions
        UserDetails userDetails = userDetailsService.loadUserByUsername("test@example.com");
        assertThat(userDetails).isNotNull();
        // Effectuez d'autres assertions sur les détails de l'utilisateur simulé.
    }

    @Test
    void testAuthenticationProvider() {
        AuthenticationProvider authenticationProvider = applicationConfig.authenticationProvider();
        assertThat(authenticationProvider).isNotNull();
        // Effectuez d'autres assertions si nécessaire.
    }

    @Test
    void testAuthenticationManager() throws Exception {
        AuthenticationConfiguration authenticationConfiguration = mock(AuthenticationConfiguration.class);
        when(authenticationConfiguration.getAuthenticationManager()).thenReturn(new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                return null;
            }
        });

        AuthenticationManager authenticationManager = applicationConfig.authenticationManager(authenticationConfiguration);
        assertThat(authenticationManager).isNotNull();
        // Effectuez d'autres assertions si nécessaire.
    }

    @Test
    void testPasswordEncoder() {
        PasswordEncoder passwordEncoder = applicationConfig.passwordEncoder();
        assertThat(passwordEncoder).isNotNull();
        // Effectuez d'autres assertions si nécessaire.
    }
}
