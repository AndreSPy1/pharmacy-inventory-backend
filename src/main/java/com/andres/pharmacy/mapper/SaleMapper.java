package com.andres.pharmacy.mapper;

import com.andres.pharmacy.dto.SaleDetailResponse;
import com.andres.pharmacy.dto.SaleResponse;
import com.andres.pharmacy.entity.Sale;
import com.andres.pharmacy.entity.SaleDetail;

import java.util.List;

public class SaleMapper {

    private SaleMapper() {
    }

    public static SaleResponse toResponse(Sale sale) {
        List<SaleDetailResponse> details = sale.getDetails()
                .stream()
                .map(SaleMapper::toDetailResponse)
                .toList();

        return SaleResponse.builder()
                .id(sale.getId())
                .total(sale.getTotal())
                .createdAt(sale.getCreatedAt())
                .details(details)
                .build();
    }

    private static SaleDetailResponse toDetailResponse(SaleDetail detail) {
        return SaleDetailResponse.builder()
                .productId(detail.getProduct().getId())
                .productName(detail.getProduct().getName())
                .quantity(detail.getQuantity())
                .unitPrice(detail.getUnitPrice())
                .subtotal(detail.getSubtotal())
                .build();
    }
}
