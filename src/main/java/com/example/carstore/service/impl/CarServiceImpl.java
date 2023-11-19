package com.example.carstore.service.impl;

import com.example.carstore.domain.car.Car;
import com.example.carstore.domain.exception.ResourceNotFoundException;
import com.example.carstore.repository.CarRepository;
import com.example.carstore.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Car> getCars() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Car getByUuid(UUID uuid) {
        return repository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("Car not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> getByUserUuid(UUID uuid) {
        return repository.findCarsByUserUuid(uuid);
    }

    @Override
    @Transactional
    public Car update(Car car) {
        return repository.save(car);
    }

    @Override
    @Transactional
    public Car create(Car car) {
        return repository.save(car);
    }

    @Override
    @Transactional
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }
}
