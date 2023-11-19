package com.example.carstore.web.dto.user;

import com.example.carstore.web.dto.validation.OnCreate;
import com.example.carstore.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class UserDto {

    @NotNull(message = "uuid must be not null", groups = OnUpdate.class)
    private UUID uuid;

    @NotNull(message = "first name must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols.", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @Email
    @NotNull(message = "email name must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "email length must be smaller than 255 symbols.", groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "password name must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols.", groups = {OnCreate.class, OnUpdate.class})
    private String password;
}
