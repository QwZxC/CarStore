package com.example.carstore.web.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest {

    @NotNull(message = "username must be not null")
    @Length(max = 255, message = "email must be smaller than 255 symbols")
    private String username;

    @NotNull(message = "password must be not null")
    @Length(max = 255, message = "password must be smaller than 255 symbols")
    private String password;
}
