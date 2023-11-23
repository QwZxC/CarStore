package com.example.carstore.web.controller;

import com.example.carstore.service.ShoppingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/shopping")
@Tag(name = "Shopping Controller", description = "Shopping")
public class ShoppingController {

    private final ShoppingService shoppingService;
    @PutMapping("/{uuid}")
    public ResponseEntity<String> buyCar(@PathVariable UUID uuid) {
        return ResponseEntity.ok(shoppingService.BuyCar(uuid));
    }
}
