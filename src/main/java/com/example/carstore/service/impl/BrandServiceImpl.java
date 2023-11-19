package com.example.carstore.service.impl;

import com.example.carstore.domain.brand.Brand;
import com.example.carstore.repository.BrandRepository;
import com.example.carstore.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository repository;

    @Override
    public Brand getByUuid(UUID uuid) {
        return repository.findById(uuid).orElseThrow();
    }

    @Override
    public Brand update(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public Brand create(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }
}
