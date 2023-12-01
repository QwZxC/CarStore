package com.example.carstore.service.impl;

import com.example.carstore.domain.car.Car;
import com.example.carstore.domain.exception.AccessDeniedException;
import com.example.carstore.domain.exception.NotEnoughMoneyException;
import com.example.carstore.domain.exception.ResourceNotFoundException;
import com.example.carstore.domain.exception.TimesUpException;
import com.example.carstore.domain.purchase.Purchase;
import com.example.carstore.domain.sale.Sale;
import com.example.carstore.domain.user.User;
import com.example.carstore.repository.CarRepository;
import com.example.carstore.repository.PurchaseRepository;
import com.example.carstore.repository.SaleRepository;
import com.example.carstore.repository.UserRepository;
import com.example.carstore.service.PurchaseService;
import com.example.carstore.web.security.JwtEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final SaleRepository saleRepository;
    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Override
    public Purchase createPurchase(UUID saleUuid) {
        Sale sale = saleRepository.findById(saleUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found"));
        User buyer = getBuyer();
        validatePurchaseOperation(sale, buyer);
        Purchase purchase = new Purchase(
                UUID.randomUUID(),
                sale.getUser(),
                buyer,
                sale.getCar(),
                LocalDateTime.now());
        purchaseRepository.save(purchase);
        changeUserBalance(sale.getUser(), buyer, sale);
        changeSaleStatus(sale);
        changeCarUser(sale.getCar(), buyer);
        return purchase;
    }

    @Override
    public String cancelPurchase(UUID purchaseUuid) {
        Purchase purchase = purchaseRepository.findById(purchaseUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase not found"));
        Sale sale = saleRepository.findLastSaleByCarUuid(purchase.getCar().getUuid())
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found"));
        LocalDateTime timeUp = purchase.getDateOfPurchase().plusMinutes(10);
        if (LocalDateTime.now().isAfter(timeUp)) {
            throw new TimesUpException();
        }
        changeUserBalance(purchase.getBuyer(), purchase.getSeller(), sale);
        changeCarUser(sale.getCar(), sale.getUser());
        sale.setDateOfWithdrawalFromSale(null);
        sale.setDateOfSale(null);
        purchaseRepository.delete(purchase);
        return "The operation was successfully canceled";
    }

    private void validatePurchaseOperation(Sale sale, User buyer) {
        if (sale.getUser().getUuid() == buyer.getUuid()) {
            throw new AccessDeniedException("You are the seller");
        }
        if (sale.getDateOfSale() != null || sale.getDateOfWithdrawalFromSale() != null) {
            throw new TimesUpException();
        }
        if (buyer.getBalance() < sale.getPrice()) {
            throw new NotEnoughMoneyException();
        }
    }

    private void changeSaleStatus(Sale sale) {
        sale.setDateOfSale(LocalDateTime.now());
        sale.setDateOfWithdrawalFromSale(LocalDateTime.now());
        saleRepository.save(sale);
    }

    private void changeUserBalance(User personToDeposit, User personWithdrawing, Sale sale) {
        personWithdrawing.setBalance(personWithdrawing.getBalance() - sale.getPrice());
        personToDeposit.setBalance(
                personToDeposit.getBalance() + sale.getPrice());
        userRepository.save(personToDeposit);
        userRepository.save(personWithdrawing);
    }

    private void changeCarUser(Car car, User buyer) {
        car.setUser(buyer);
        carRepository.save(car);
    }

    private User getBuyer() {
        return userRepository.findById(
                        ((JwtEntity) SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getPrincipal())
                                .getUuid())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
