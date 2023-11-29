package com.example.carstore.service;

import com.example.carstore.domain.sale.Sale;

import java.util.UUID;

public interface SaleService {

    String createSale(Sale sale);
    String deleteSale(UUID saleUuid);
}
