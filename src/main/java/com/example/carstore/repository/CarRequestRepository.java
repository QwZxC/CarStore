package com.example.carstore.repository;

import com.example.carstore.domain.entity.CarRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRequestRepository extends JpaRepository<CarRequest, UUID> {


}
