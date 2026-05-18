package com.andres.pharmacy.controller;

import com.andres.pharmacy.dto.InventoryMovementRequest;
import com.andres.pharmacy.dto.InventoryMovementResponse;
import com.andres.pharmacy.service.InventoryMovementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory-movements")
@RequiredArgsConstructor
public class InventoryMovementController {

    private final InventoryMovementService inventoryMovementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryMovementResponse registerMovement(
            @Valid @RequestBody InventoryMovementRequest request
    ) {
        return inventoryMovementService.registerMovement(request);
    }
}
