package com.andres.pharmacy.service.impl;

import com.andres.pharmacy.dto.SaleItemRequest;
import com.andres.pharmacy.dto.SaleRequest;
import com.andres.pharmacy.dto.SaleResponse;
import com.andres.pharmacy.entity.Product;
import com.andres.pharmacy.entity.Sale;
import com.andres.pharmacy.entity.SaleDetail;
import com.andres.pharmacy.mapper.SaleMapper;
import com.andres.pharmacy.repository.ProductRepository;
import com.andres.pharmacy.repository.SaleRepository;
import com.andres.pharmacy.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    @Override
    public SaleResponse createSale(SaleRequest request) {
        Sale sale = Sale.builder()
                .createdAt(LocalDateTime.now())
                .total(BigDecimal.ZERO)
                .details(new ArrayList<>())
                .build();

        BigDecimal total = BigDecimal.ZERO;

        for (SaleItemRequest item : request.getItems()) {
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("Product not found"));

            if (product.getStock() < item.getQuantity()) {
                throw new IllegalArgumentException("Insufficient stock for product: " + product.getName());
            }

            BigDecimal subtotal = product.getPrice()
                    .multiply(BigDecimal.valueOf(item.getQuantity()));

            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);

            SaleDetail detail = SaleDetail.builder()
                    .sale(sale)
                    .product(product)
                    .quantity(item.getQuantity())
                    .unitPrice(product.getPrice())
                    .subtotal(subtotal)
                    .build();

            sale.getDetails().add(detail);
            total = total.add(subtotal);
        }

        sale.setTotal(total);

        Sale savedSale = saleRepository.save(sale);
        return SaleMapper.toResponse(savedSale);
    }

    @Override
    public List<SaleResponse> getAllSales() {
        return saleRepository.findAll()
                .stream()
                .map(SaleMapper::toResponse)
                .toList();
    }

    @Override
    public SaleResponse getSaleById(Long id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sale not found"));

        return SaleMapper.toResponse(sale);
    }
}
