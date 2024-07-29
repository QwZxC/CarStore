package com.example.carstore.service.api;

import com.example.carstore.domain.entity.Brand;

import java.util.List;
import java.util.UUID;

public interface BrandService {


    List<Brand> getAll();
    Brand getByUuid(UUID uuid);

    Brand update(Brand brand);

    Brand create(Brand brand);

    void delete(UUID uuid);
}
