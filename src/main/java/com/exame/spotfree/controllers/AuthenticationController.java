package com.exame.spotfree.controllers;

import com.exame.spotfree.models.request.AuthenticationRequest;
import com.exame.spotfree.models.request.RegisterRequest;
import com.exame.spotfree.models.responses.AuthenticationResponse;
import com.exame.spotfree.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseBody
    public AuthenticationResponse register(@RequestBody RegisterRequest authenticationRequest) {
        return authenticationService.register(authenticationRequest);
    }

    @PostMapping("/authenticate")
    @ResponseBody
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return authenticationService.authenticate(authenticationRequest);
    }

}
