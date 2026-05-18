package com.andres.pharmacy.service;

import com.andres.pharmacy.dto.InventoryMovementRequest;
import com.andres.pharmacy.dto.InventoryMovementResponse;

public interface InventoryMovementService {

    InventoryMovementResponse registerMovement(InventoryMovementRequest request);
}
