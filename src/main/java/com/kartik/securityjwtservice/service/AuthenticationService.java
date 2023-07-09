package com.kartik.securityjwtservice.service;


import com.kartik.securityjwtservice.model.*;
import com.kartik.securityjwtservice.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(Register register) {

        User user = User.builder().firstName(register.getFirstName())
                .lastName(register.getLastName())
                .email(register.getEmail())
                .password(passwordEncoder.encode(register.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        System.out.println("New user registered :"+user);

        String jwtToken= jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .jwtToken(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(Authentication authentication) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentication.getEmail(),
                        authentication.getPassword())

        );

        System.out.println("Authentication success !");
        User user = User.builder()
                .email(authentication.getEmail())
                .build();
        String jwtToken= jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .jwtToken(jwtToken)
                .build();
    }
}
