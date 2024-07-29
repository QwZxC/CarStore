package com.example.carstore.service.impl;

import com.example.carstore.domain.entity.Brand;
import com.example.carstore.domain.exception.ResourceNotFoundException;
import com.example.carstore.repository.BrandRepository;
import com.example.carstore.service.api.BrandService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository repository;


    @Override
    public List<Brand> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Brand getByUuid(UUID uuid) {
        return repository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("Brand not found"));
    }

    @Override
    @Transactional
    public Brand update(Brand brand) {
        return repository.save(brand);
    }

    @Override
    @Transactional
    public Brand create(Brand brand) {
        return repository.save(brand);
    }

    @Override
    @Transactional
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }
}
