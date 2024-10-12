package com.sharipov.tasklist.domain.service;

import com.sharipov.tasklist.domain.web.dto.auth.AuthDTO;
import com.sharipov.tasklist.domain.web.dto.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(AuthDTO loginRequest);
    JwtResponse refresh(String refreshToken);
}
