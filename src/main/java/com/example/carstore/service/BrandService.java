package com.example.carstore.service;

import com.example.carstore.domain.brand.Brand;

import java.util.UUID;

public interface BrandService {

    Brand getByUuid(UUID uuid);

    Brand update(Brand brand);

    Brand create(Brand brand);

    void delete(UUID uuid);
}
