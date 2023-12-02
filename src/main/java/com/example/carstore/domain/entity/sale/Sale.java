package com.example.carstore.domain.entity.sale;

import com.example.carstore.domain.entity.car.Car;
import com.example.carstore.domain.entity.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Sale {

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;
    @Column(name = "price", nullable = false)
    private Long price;
    @ManyToOne
    @JoinColumn(name = "car_uuid", nullable = false)
    private Car car;
    @Column(name = "date_of_creation")
    private LocalDateTime dateOfCreation;
    @Column(name = "date_of_sale")
    private LocalDateTime dateOfSale;
    @Column(name = "date_of_withdrawal_from_sale")
    private LocalDateTime dateOfWithdrawalFromSale;
}
