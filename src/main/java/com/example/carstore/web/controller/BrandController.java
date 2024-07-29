package com.example.carstore.web.controller;

import com.example.carstore.domain.entity.Brand;
import com.example.carstore.service.api.BrandService;
import com.example.carstore.web.dto.brand.BrandDto;
import com.example.carstore.web.dto.validation.OnUpdate;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/brands")
@Tag(name = "Brand Controller", description = "Brand")
public class BrandController {

    private final ModelMapper mapper;
    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandDto>> getAll(){
        List<BrandDto> brands = brandService.getAll()
                .stream()
                .map(brand -> mapper.map(brand, BrandDto.class ))
                .toList();

        return ResponseEntity.ok(brands);
    }

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
