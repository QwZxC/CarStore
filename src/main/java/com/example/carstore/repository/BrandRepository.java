package com.example.carstore.repository;

import com.example.carstore.domain.brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {

    Brand findByName(String name);
}
