package com.example.carstore.repository;

import com.example.carstore.domain.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SaleRepository extends JpaRepository<Sale, UUID> {

    Boolean existsSaleByCarUuid(UUID carUuid);
    Optional<Sale> findLastSaleByCarUuid(UUID carUuid);
}
