package com.example.carstore.domain.car;

import com.example.carstore.domain.brand.Brand;
import com.example.carstore.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Car {

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;
    @Column(name = "price", nullable = false)
    private Long price;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
}
