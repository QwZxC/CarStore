package com.example.carstore.web.dto.purchase;

import com.example.carstore.web.dto.car.CarDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class PurchaseDto {

    private UUID uuid;
    private CarDto car;
    private LocalDateTime dateOfPurchase;
}
