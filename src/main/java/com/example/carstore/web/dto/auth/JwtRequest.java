package com.example.carstore.web.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class JwtRequest {

    @Email
    @NotNull(message = "username must be not null")
    @Length(max = 255, message = "email must be smaller than 255 symbols")
    private String username;

    @NotNull(message = "password must be not null")
    @Length(max = 255, message = "password must be smaller than 255 symbols")
    private String password;
}
