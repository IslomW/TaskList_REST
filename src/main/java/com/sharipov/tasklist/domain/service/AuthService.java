package com.sharipov.tasklist.domain.service;

import com.sharipov.tasklist.domain.web.dto.auth.JwtRequest;
import com.sharipov.tasklist.domain.web.dto.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest loginRequest);
    JwtResponse refresh(String refreshToken);
}
