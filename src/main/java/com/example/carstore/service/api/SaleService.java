package com.example.carstore.service.api;

import com.example.carstore.domain.entity.Sale;

import java.util.UUID;

public interface SaleService {

    String createSale(Sale sale);
    String deleteSale(UUID saleUuid);
    Sale updateSale(Sale sale);
}
