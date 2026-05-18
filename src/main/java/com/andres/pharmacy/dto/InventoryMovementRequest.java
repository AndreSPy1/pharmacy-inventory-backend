package com.andres.pharmacy.dto;

import com.andres.pharmacy.entity.InventoryMovementType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class InventoryMovementRequest {

    @NotNull
    private Long productId;

    @NotNull
    @Positive
    private Integer quantity;

    @NotNull
    private InventoryMovementType type;

    private String reason;
}
