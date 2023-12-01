package com.example.carstore.domain.purchase;

import com.example.carstore.domain.car.Car;
import com.example.carstore.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    @Id
    @Column(name = "uuid", nullable = false)
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "seller_uuid")
    private User seller;
    @ManyToOne
    @JoinColumn(name = "buyer_uuid")
    private User buyer;
    @ManyToOne
    @JoinColumn(name = "car_uuid", nullable = false)
    private Car car;
    @Column(name = "date_of_purchase")
    private LocalDateTime dateOfPurchase;
}
