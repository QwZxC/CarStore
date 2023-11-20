package com.example.carstore.service.impl;

import com.example.carstore.domain.user.User;
import com.example.carstore.service.AuthService;
import com.example.carstore.service.UserService;
import com.example.carstore.web.dto.auth.JwtRequest;
import com.example.carstore.web.dto.auth.JwtResponse;
import com.example.carstore.web.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        User user = userService.getByUsername(loginRequest.getUsername());
        return JwtResponse.builder()
                .uuid(user.getUuid())
                .username(user.getUsername())
                .accessToken(jwtTokenProvider.createAccessToken(user.getUuid(), user.getUsername(), user.getRoles()))
                .refreshToken(jwtTokenProvider.createRefreshToken(user.getUuid(), user.getUsername()))
                .build();
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return jwtTokenProvider.refreshUserTokens(refreshToken);
    }
}
