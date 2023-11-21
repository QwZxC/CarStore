package com.example.carstore.web.controller;

import com.example.carstore.service.ShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/shopping")
public class ShoppingController {

    private final ShoppingService shoppingService;
    @PutMapping("/{uuid}")
    public ResponseEntity<String> buyCar(@PathVariable UUID uuid, @RequestHeader(name = "Authorization") String jwt) {
        return ResponseEntity.ok(shoppingService.BuyCar(uuid, jwt.substring(7)));
    }
}
