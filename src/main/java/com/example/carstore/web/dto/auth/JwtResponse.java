package com.example.carstore.web.dto.auth;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
public class JwtResponse {

    private UUID uuid;
    private String username;
    private String accessToken;
    private String refreshToken;
}
