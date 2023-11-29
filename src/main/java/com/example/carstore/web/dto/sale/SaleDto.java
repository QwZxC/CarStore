package com.example.carstore.web.dto.sale;

import com.example.carstore.web.dto.car.CarDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SaleDto {

    private UUID uuid;
    private CarDto car;
    private Long price;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfSale;
    private LocalDateTime dateOfWithdrawalFromSale;
}
