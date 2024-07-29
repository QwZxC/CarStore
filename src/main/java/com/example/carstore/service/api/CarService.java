package com.example.carstore.service.api;

import com.example.carstore.domain.entity.Car;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.UUID;

public interface CarService {

    List<Car> getCars(PageRequest pageRequest);

    Car getByUuid(UUID uuid);

    List<Car> getByUserUuid(UUID uuid);

    Car update(Car car);

    Car create(Car car);

    void delete(UUID uuid);
}
