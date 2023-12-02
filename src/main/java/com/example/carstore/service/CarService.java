package com.example.carstore.service;

import com.example.carstore.domain.entity.car.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {

    List<Car> getCars();

    Car getByUuid(UUID uuid);

    List<Car> getByUserUuid(UUID uuid);

    Car update(Car car);

    Car create(Car car);

    void delete(UUID uuid);
}
