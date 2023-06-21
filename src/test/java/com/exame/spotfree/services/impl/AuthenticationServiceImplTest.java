package com.exame.spotfree.services.impl;

import com.exame.spotfree.models.request.AuthenticationRequest;
import com.exame.spotfree.models.request.RegisterRequest;
import com.exame.spotfree.models.responses.AuthenticationResponse;
import com.exame.spotfree.repositorys.UserRepository;
import com.exame.spotfree.services.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

class AuthenticationServiceImplTest {

    @InjectMocks
    AuthenticationServiceImpl authenticationService;

    @Mock
    UserRepository userRepository;

    @Mock
    JwtService jwtService;

    @Mock
    AuthenticationManager authenticationManager;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testIfisThorwsAEXceptionWhenUserIsNotRegistered() {

        assertThrows(UsernameNotFoundException.class, ()->
                authenticationService.authenticate(new AuthenticationRequest("exemplo", "password"))
        );

    }
}