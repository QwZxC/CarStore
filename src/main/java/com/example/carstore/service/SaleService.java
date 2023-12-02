package com.example.carstore.service;

import com.example.carstore.domain.entity.sale.Sale;
import com.example.carstore.web.dto.purchase.PurchaseDto;

import java.util.UUID;

public interface SaleService {

    String createSale(Sale sale);
    String deleteSale(UUID saleUuid);
    PurchaseDto updateSale(Sale sale);
}
