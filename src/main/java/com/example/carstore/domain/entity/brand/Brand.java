package com.example.carstore.domain.entity.brand;

import com.example.carstore.domain.entity.car.Car;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Brand {

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;
    @Column(name = "name",nullable = false)
    private String name;
    @OneToMany(mappedBy = "brand")
    private List<Car> cars;
}
