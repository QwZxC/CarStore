package com.example.carstore.service;

import com.example.carstore.domain.entity.brand.Brand;

import java.util.List;
import java.util.UUID;

public interface BrandService {


    List<Brand> getAll();
    Brand getByUuid(UUID uuid);

    Brand update(Brand brand);

    Brand create(Brand brand);

    void delete(UUID uuid);
}
