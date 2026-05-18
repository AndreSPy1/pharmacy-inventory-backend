package com.andres.pharmacy.dto;

import com.andres.pharmacy.entity.InventoryMovementType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class InventoryMovementResponse {

    private Long id;
    private Long productId;
    private String productName;
    private Integer quantity;
    private InventoryMovementType type;
    private String reason;
    private LocalDateTime createdAt;
    private Integer currentStock;
}
