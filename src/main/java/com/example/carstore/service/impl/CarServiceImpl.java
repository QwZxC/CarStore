package com.example.carstore.service.impl;

import com.example.carstore.domain.car.Car;
import com.example.carstore.repository.CarRepository;
import com.example.carstore.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    @Override
    public List<Car> getCars() {
        return repository.findAll();
    }

    @Override
    public Car getByUuid(UUID uuid) {
        return repository.findById(uuid).orElseThrow();
    }

    @Override
    public List<Car> getByUserUuid(UUID uuid) {
        return repository.findCarsByUserUuid(uuid);
    }

    @Override
    public Car update(Car car) {
        return repository.save(car);
    }

    @Override
    public Car create(Car car, UUID userUuid) {
        return repository.save(car);
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }
}
