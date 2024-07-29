package com.example.carstore.repository;

import com.example.carstore.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {

    List<Car> findCarsByUserUuid(UUID uuid);

    Optional<Car> findByName(String name);
}
