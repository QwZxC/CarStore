package com.example.carstore.domain.car;

import com.example.carstore.domain.brand.Brand;
import com.example.carstore.domain.sale.Sale;
import com.example.carstore.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Car {

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
    @OneToMany(mappedBy = "car")
    private List<Sale> sale = new ArrayList<>();
}
