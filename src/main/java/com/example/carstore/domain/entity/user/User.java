package com.example.carstore.domain.entity.user;

import com.example.carstore.domain.entity.car.Car;
import com.example.carstore.domain.entity.sale.Sale;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "balance", nullable = false)
    private Long balance = 0L;
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles")
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;
    @OneToMany(mappedBy = "user")
    private List<Car> cars = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Sale> sales = new ArrayList<>();
}
