package com.andres.pharmacy.mapper;

import com.andres.pharmacy.dto.InventoryMovementResponse;
import com.andres.pharmacy.entity.InventoryMovement;

public class InventoryMovementMapper {

    private InventoryMovementMapper() {
    }

    public static InventoryMovementResponse toResponse(InventoryMovement movement, Integer currentStock) {
        return InventoryMovementResponse.builder()
                .id(movement.getId())
                .productId(movement.getProduct().getId())
                .productName(movement.getProduct().getName())
                .quantity(movement.getQuantity())
                .type(movement.getType())
                .reason(movement.getReason())
                .createdAt(movement.getCreatedAt())
                .currentStock(currentStock)
                .build();
    }
}
