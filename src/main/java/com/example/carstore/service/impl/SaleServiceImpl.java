package com.example.carstore.service.impl;

import com.example.carstore.domain.entity.car.Car;
import com.example.carstore.domain.exception.AccessDeniedException;
import com.example.carstore.domain.exception.AlreadySellingException;
import com.example.carstore.domain.exception.ResourceNotFoundException;
import com.example.carstore.domain.entity.sale.Sale;
import com.example.carstore.repository.CarRepository;
import com.example.carstore.repository.SaleRepository;
import com.example.carstore.service.SaleService;
import com.example.carstore.web.security.JwtEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final CarRepository carRepository;

    @Override
    public String createSale(Sale sale) {
        Car salingCar = carRepository.findById(sale.getCar().getUuid()).orElseThrow(() -> new ResourceNotFoundException("Car not found"));
        ownerVerification(salingCar);
        if (saleRepository.existsSaleByCarUuid(salingCar.getUuid())) {
            throw new AlreadySellingException("You are already selling this car");
        }
        sale.setUser(salingCar.getUser());
        saleRepository.save(sale);
        return "Successfully put up for sale";
    }

    @Override
    public String deleteSale(UUID saleUuid) {
        ownerVerification(
                saleRepository.findById(saleUuid).orElseThrow(() -> new ResourceNotFoundException("Sale not found"))
                        .getCar()
        );
        saleRepository.deleteById(saleUuid);
        return "Successfully withdrawn from sale";
    }

    private void ownerVerification(Car car) {
        if (car.getUser() == null) {
            return;
        }
        UUID authorizedUserUuid = getAuthorizedUserUuid();
        UUID carUserUuid = car.getUser().getUuid();
        if (!carUserUuid.equals(authorizedUserUuid)) {
            throw new AccessDeniedException("You are not the owner of this car");
        }
    }

    private UUID getAuthorizedUserUuid() {
        return ((JwtEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUuid();
    }
}
