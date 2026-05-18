package com.andres.pharmacy.service.impl;

import com.andres.pharmacy.dto.InventoryMovementRequest;
import com.andres.pharmacy.dto.InventoryMovementResponse;
import com.andres.pharmacy.entity.InventoryMovement;
import com.andres.pharmacy.entity.InventoryMovementType;
import com.andres.pharmacy.entity.Product;
import com.andres.pharmacy.mapper.InventoryMovementMapper;
import com.andres.pharmacy.repository.InventoryMovementRepository;
import com.andres.pharmacy.repository.ProductRepository;
import com.andres.pharmacy.service.InventoryMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InventoryMovementServiceImpl implements InventoryMovementService {

    private final InventoryMovementRepository inventoryMovementRepository;
    private final ProductRepository productRepository;

    @Override
    public InventoryMovementResponse registerMovement(InventoryMovementRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        int newStock = calculateNewStock(product.getStock(), request);

        product.setStock(newStock);
        productRepository.save(product);

        InventoryMovement movement = InventoryMovement.builder()
                .product(product)
                .quantity(request.getQuantity())
                .type(request.getType())
                .reason(request.getReason())
                .createdAt(LocalDateTime.now())
                .build();

        InventoryMovement savedMovement = inventoryMovementRepository.save(movement);

        return InventoryMovementMapper.toResponse(savedMovement, newStock);
    }

    private int calculateNewStock(Integer currentStock, InventoryMovementRequest request) {
        if (request.getType() == InventoryMovementType.IN) {
            return currentStock + request.getQuantity();
        }

        int newStock = currentStock - request.getQuantity();

        if (newStock < 0) {
            throw new IllegalArgumentException("Insufficient stock for this movement");
        }

        return newStock;
    }
}
