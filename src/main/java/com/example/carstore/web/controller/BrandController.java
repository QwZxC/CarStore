package com.example.carstore.web.controller;

import com.example.carstore.domain.brand.Brand;
import com.example.carstore.service.BrandService;
import com.example.carstore.web.dto.brand.BrandDto;
import com.example.carstore.web.dto.validation.OnUpdate;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandController {

    private final ModelMapper mapper;
    private final BrandService brandService;

    @GetMapping("/{uuid}")
    public ResponseEntity<BrandDto> getByUuid(@PathVariable UUID uuid) {
        return ResponseEntity
                .ok(mapper.map(brandService.getByUuid(uuid), BrandDto.class));
    }

    @PutMapping
    public ResponseEntity<BrandDto> update(@Validated(OnUpdate.class) @RequestBody BrandDto dto) {
        Brand brand = mapper.map(dto, Brand.class);
        return ResponseEntity
                .ok(mapper.map(brandService.update(brand), BrandDto.class));
    }

    @DeleteMapping("/{uuid}")
    public HttpStatus deleteByUuid(@PathVariable UUID uuid) {
        brandService.delete(uuid);
        return HttpStatus.OK;
    }
}
