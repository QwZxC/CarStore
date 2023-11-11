package com.example.carstore.domain.car;

import lombok.Data;

import java.util.UUID;

@Data
public class Car {

    private UUID uuid;
    private String name;

}
