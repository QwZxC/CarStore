package com.example.carstore.service.impl;

import com.example.carstore.domain.car.Car;
import com.example.carstore.domain.exception.AlreadyTakenException;
import com.example.carstore.domain.exception.NotEnoughMoneyException;
import com.example.carstore.domain.user.User;
import com.example.carstore.repository.CarRepository;
import com.example.carstore.repository.UserRepository;
import com.example.carstore.service.ShoppingService;
import com.example.carstore.web.security.JwtEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShoppingServiceImpl implements ShoppingService {

    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Override
    public String BuyCar(UUID carUuid) {
        Car car = carRepository.getReferenceById(carUuid);
        if (car.getUser() != null) {
            throw new AlreadyTakenException(String.format("%s уже занята", car.getName()));
        }
        User user = getUser();
        if (user.getBalance() - car.getPrice() < 0) {
            throw new NotEnoughMoneyException();
        }
        user.setBalance(user.getBalance() - car.getPrice());
        car.setUser(user);
        carRepository.save(car);
        userRepository.save(user);
        return "Успешная покупка";
    }

    private User getUser() {
        JwtEntity authUser = (JwtEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.getReferenceById(authUser.getUuid());
    }
}
