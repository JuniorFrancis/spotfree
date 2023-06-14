package com.exame.spotfree.services.impl;

import com.exame.spotfree.constants.Role;
import com.exame.spotfree.models.User;
import com.exame.spotfree.models.request.AuthenticationRequest;
import com.exame.spotfree.models.request.RegisterRequest;
import com.exame.spotfree.models.responses.AuthenticationResponse;
import com.exame.spotfree.repositorys.UserRepository;
import com.exame.spotfree.services.AuthenticationService;
import com.exame.spotfree.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository,
                                     PasswordEncoder encoder,
                                     JwtService jwtService,
                                     AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        Optional<User> user = userRepository.findByUsername(request.getEmail());

        String jwtToken = jwtService.generateToken(user.get());

        return new AuthenticationResponse.Builder()
                .withToken(jwtToken)
                .build();

    }

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
           User user = new User.Builder()
                   .withFirstname(request.getFirstname())
                   .withUsername(request.getUsername())
                   .withPassword(encoder.encode(request.getPassword()))
                   .withRole(Role.COMMON)
                   .build();

           userRepository.save(user);

           String jwtToken = jwtService.generateToken(user);

           return new AuthenticationResponse.Builder()
                   .withToken(jwtToken)
                   .build();

    }
}
