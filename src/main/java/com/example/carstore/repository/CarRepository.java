package com.example.carstore.repository;

import com.example.carstore.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {

    List<Car> findCarsByUserUuid(UUID uuid);
    @Query(value = """
                   SELECT * FROM public.car c
                   WHERE c.name like :name
                   """, nativeQuery = true)
    List<Car> findAllByName(@Param("name") String name);
}
