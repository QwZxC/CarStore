package com.example.carstore.web.controller;

import com.example.carstore.domain.entity.Sale;
import com.example.carstore.service.api.SaleService;
import com.example.carstore.web.dto.sale.SaleDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/sales")
public class SaleController {

    private final SaleService saleService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<String> createSale(@RequestBody SaleDto dto) {
        return ResponseEntity.ok(
                saleService.createSale(mapper.map(dto, Sale.class)));
    }

    @PutMapping
    public ResponseEntity<SaleDto> updateSale(@RequestBody SaleDto dto) {
        return ResponseEntity.ok(
                mapper.map(
                        saleService.updateSale(
                                mapper.map(dto, Sale.class)
                        ),
                        SaleDto.class)
        );
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteSale(@PathVariable UUID uuid) {
        return ResponseEntity.ok(saleService.deleteSale(uuid));
    }
}
