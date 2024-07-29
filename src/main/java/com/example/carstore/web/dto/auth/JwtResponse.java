package com.example.carstore.web.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class JwtResponse {

    private UUID uuid;
    private String username;
    private String accessToken;
    private String refreshToken;
}
