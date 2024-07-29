package com.example.carstore.web.controller;

import com.example.carstore.service.api.CarService;
import com.example.carstore.web.dto.car.CarDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cars")
@Tag(name = "Car Controller", description = "Car")
public class CarController {

    private final CarService carService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CarDto>> getCars(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "") String carName
    ) {
        if (carName.isBlank()) {
            return ResponseEntity.ok(
                    carService.getCars(PageRequest.of(page, size))
                            .stream()
                            .map(car -> mapper.map(car, CarDto.class))
                            .toList()
            );
        }
        return ResponseEntity.ok(
                carService.getCars(carName)
                        .stream()
                        .map(car -> mapper.map(car, CarDto.class))
                        .toList()
        );
    }
}
