package com.example.carstore.web.dto.brand;

import com.example.carstore.domain.car.Car;
import com.example.carstore.web.dto.validation.OnCreate;
import com.example.carstore.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.UUID;

@Data
public class BrandDto {

    @NotNull(message = "uuid must be not null", groups = OnUpdate.class)
    private UUID uuid;

    @NotNull(message = "uuid must be not null", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "name must be smaller than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    private String name;

    private List<Car> cars;
}
