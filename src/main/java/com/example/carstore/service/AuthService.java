package com.example.carstore.service;

import com.example.carstore.web.dto.auth.JwtRequest;
import com.example.carstore.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);
}
