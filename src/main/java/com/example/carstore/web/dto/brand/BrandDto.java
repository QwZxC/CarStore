package com.example.carstore.domain.brand;

import com.example.carstore.domain.car.Car;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Brand {

    private UUID uuid;
    private String name;
    private List<Car> cars;
}
