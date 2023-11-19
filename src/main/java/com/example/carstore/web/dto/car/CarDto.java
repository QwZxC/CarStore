package com.example.carstore.web.dto.car;

import com.example.carstore.web.dto.validation.OnCreate;
import com.example.carstore.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CarDto {

    @NotNull(message = "uuid must be not null", groups = OnUpdate.class)
    private UUID uuid;

    @NotNull(message = "name must be not null", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "name must be smaller than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String name;
}
