package com.example.carstore.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class CarRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @JoinColumn(name = "car_id")
    @ManyToOne
    private Car car;
}
