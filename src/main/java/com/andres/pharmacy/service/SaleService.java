package com.andres.pharmacy.service;

import com.andres.pharmacy.dto.SaleRequest;
import com.andres.pharmacy.dto.SaleResponse;

import java.util.List;

public interface SaleService {

    SaleResponse createSale(SaleRequest request);

    List<SaleResponse> getAllSales();

    SaleResponse getSaleById(Long id);
}
