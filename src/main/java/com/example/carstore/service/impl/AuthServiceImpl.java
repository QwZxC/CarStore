package com.example.carstore.service.impl;

import com.example.carstore.service.AuthService;
import com.example.carstore.web.dto.auth.JwtRequest;
import com.example.carstore.web.dto.auth.JwtResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
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
