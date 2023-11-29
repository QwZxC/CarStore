package com.example.carstore.web.controller;

import com.example.carstore.domain.user.User;
import com.example.carstore.service.AuthService;
import com.example.carstore.service.UserService;
import com.example.carstore.web.dto.auth.JwtRequest;
import com.example.carstore.web.dto.auth.JwtResponse;
import com.example.carstore.web.dto.user.UserDto;
import com.example.carstore.web.dto.validation.OnCreate;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Auth Controller", description = "Auth")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Validated @RequestBody JwtRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@Validated(OnCreate.class) @RequestBody UserDto dto) {
        dto.setUuid(UUID.randomUUID());
        userService.create(modelMapper.map(dto, User.class));
        return ResponseEntity.ok(
                authService.login(
                        JwtRequest.builder()
                                .username(dto.getUsername())
                                .password(dto.getPassword())
                                .build()
                ));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refresh(@RequestBody String refreshToken) {
        return ResponseEntity.ok(authService.refresh(refreshToken));
    }
}
