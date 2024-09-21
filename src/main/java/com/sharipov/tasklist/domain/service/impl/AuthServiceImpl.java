package com.sharipov.tasklist.domain.service.impl;

import com.sharipov.tasklist.domain.service.AuthService;
import com.sharipov.tasklist.domain.web.dto.auth.JwtRequest;
import com.sharipov.tasklist.domain.web.dto.auth.JwtResponse;

public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
