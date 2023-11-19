package com.example.carstore.web.controller;

import com.example.carstore.domain.car.Car;
import com.example.carstore.domain.user.User;
import com.example.carstore.service.CarService;
import com.example.carstore.service.UserService;
import com.example.carstore.web.dto.car.CarDto;
import com.example.carstore.web.dto.user.UserDto;
import com.example.carstore.web.dto.validation.OnCreate;
import com.example.carstore.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final CarService carService;
    private final ModelMapper mapper;

    @PutMapping
    public ResponseEntity<UserDto> update(@Validated(OnUpdate.class) @RequestBody UserDto dto) {
        User user = mapper.map(dto, User.class);
        return ResponseEntity
                .ok(mapper.map(userService.update(user), UserDto.class));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserDto> getByUuid(@PathVariable UUID uuid) {
        return ResponseEntity
                .ok(mapper.map(userService.getByUuid(uuid), UserDto.class));
    }

    @GetMapping
    public ResponseEntity<UserDto> getByUserName(@RequestParam @Email String username) {
        return ResponseEntity
                .ok(mapper.map(userService.getByUsername(username), UserDto.class));
    }

    @DeleteMapping("/{uuid}")
    public HttpStatus deleteByUuid(@PathVariable UUID uuid) {
        userService.delete(uuid);
        return HttpStatus.OK;
    }

    @GetMapping("/{uuid}/cars")
    public ResponseEntity<List<CarDto>> getUserCars(@PathVariable UUID uuid) {
        return ResponseEntity.ok(
                carService.getByUserUuid(uuid)
                        .stream()
                        .map(car -> mapper.map(car, CarDto.class))
                        .collect(Collectors.toList())
        );
    }

    @PostMapping("/{uuid}/cars")
    public ResponseEntity<CarDto> createCar(@PathVariable UUID uuid,
                                            @Validated(OnCreate.class) @RequestBody CarDto dto
    ) {
        Car car = mapper.map(dto, Car.class);
        return ResponseEntity
                .ok(mapper.map(carService.create(car, uuid), CarDto.class));
    }
}
