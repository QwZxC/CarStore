package com.example.carstore.web.controller;

import com.example.carstore.service.api.PurchaseService;
import com.example.carstore.web.dto.purchase.PurchaseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final ModelMapper mapper;

    @PostMapping("/{saleUuid}")
    public ResponseEntity<PurchaseDto> createPurchase(@PathVariable UUID saleUuid) {
        return ResponseEntity.ok(
                mapper.map(purchaseService.createPurchase(saleUuid), PurchaseDto.class)
        );
    }

    @DeleteMapping("/{purchaseUuid}")
    public ResponseEntity<String> deletePurchase(@PathVariable UUID purchaseUuid) {
        return ResponseEntity.ok(purchaseService.cancelPurchase(purchaseUuid));
    }
}
