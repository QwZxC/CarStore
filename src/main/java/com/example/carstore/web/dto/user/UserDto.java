package com.example.carstore.domain.user;

import com.example.carstore.domain.car.Car;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
public class User {

    private UUID uuid;
    private String first_name;
    private String username;
    private String password;
    private Set<Role> roles;
    private List<Car> cars;

}
