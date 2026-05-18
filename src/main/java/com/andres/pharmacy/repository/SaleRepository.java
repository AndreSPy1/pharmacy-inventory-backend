package com.andres.pharmacy.repository;

import com.andres.pharmacy.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
