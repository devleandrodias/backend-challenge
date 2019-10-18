package com.challenge.saleservice.repository;

import com.challenge.saleservice.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
