package com.example.carstore.service.impl;

import com.example.carstore.domain.car.Car;
import com.example.carstore.domain.exception.AlreadyTakenException;
import com.example.carstore.domain.exception.NotEnoughMoneyException;
import com.example.carstore.domain.user.User;
import com.example.carstore.repository.CarRepository;
import com.example.carstore.repository.UserRepository;
import com.example.carstore.service.ShoppingService;
import com.example.carstore.service.props.JwtProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShoppingServiceImpl implements ShoppingService {

    private final JwtProperties jwtProperties;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private Key key;

    @PostConstruct
    public void init() {
        key = Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes());
    }

    @Override
    public String BuyCar(UUID carUuid, String token) {
        Car car = carRepository.getReferenceById(carUuid);
        if (car.getUser() != null) {
            throw new AlreadyTakenException(String.format("%s уже занята", car.getName()));
        }
        UUID userUuid = UUID.fromString(getUuid(token));
        User user = userRepository.getReferenceById(userUuid);

        if (user.getBalance() - car.getPrice() < 0) {
            throw new NotEnoughMoneyException();
        }
        user.setBalance(user.getBalance() - car.getPrice());
        car.setUser(user);
        carRepository.save(car);
        userRepository.save(user);
        return "Успешная покупка";
    }

    private String getUuid(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("uuid")
                .toString();
    }
}
