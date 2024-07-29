package com.example.carstore.service.api;

import com.example.carstore.domain.entity.Purchase;

import java.util.UUID;

public interface PurchaseService {

    Purchase createPurchase(UUID saleUuid);

    String cancelPurchase(UUID purchaseUuid);
}
