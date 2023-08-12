package com.KNops.Authenticationservice.auth;


import com.KNops.Authenticationservice.config.JwtService;
import com.KNops.Authenticationservice.user.Role;
import com.KNops.Authenticationservice.user.User;
import com.KNops.Authenticationservice.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public com.KNops.Authenticationservice.auth.AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return com.KNops.Authenticationservice.auth.AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public com.KNops.Authenticationservice.auth.AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return com.KNops.Authenticationservice.auth.AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}