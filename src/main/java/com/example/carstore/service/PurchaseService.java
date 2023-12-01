package com.example.carstore.service;

import com.example.carstore.domain.purchase.Purchase;

import java.util.UUID;

public interface PurchaseService {

    Purchase createPurchase(UUID saleUuid);

    String cancelPurchase(UUID purchaseUuid);
}
