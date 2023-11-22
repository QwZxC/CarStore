package com.example.carstore.web.controller;

import com.example.carstore.service.CarService;
import com.example.carstore.web.dto.car.CarDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cars")
@Tag(name = "Car Controller", description = "Car")
public class CarController {

    private final CarService carService;
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CarDto>> getCars() {
        return ResponseEntity.ok(
                carService.getCars()
                        .stream()
                        .map(car -> mapper.map(car, CarDto.class))
                        .collect(Collectors.toList())
        );
    }
}
