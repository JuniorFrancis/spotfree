package com.exame.spotfree.services;

import com.exame.spotfree.models.request.AuthenticationRequest;
import com.exame.spotfree.models.request.RegisterRequest;
import com.exame.spotfree.models.responses.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    AuthenticationResponse register(RegisterRequest authenticationRequest);
}
